```java
@Configuration
public class NotificationConfiguration {

    // use fcm service account resource
    @Bean
    GoogleCredentials googleCredential(PropertiesBean properties) {
        Resource fcmServiceAccountResource = properties.getFcmServiceAccountResource();
        try {
            if (fcmServiceAccountResource != null) {
                try (InputStream inputStream = fcmServiceAccountResource.getInputStream()) {
                    return GoogleCredentials.fromStream(inputStream);
                }
            }
            return GoogleCredentials.getApplicationDefault();
        } catch (IOException e) {
            log.error(e.getMessage());
            return GoogleCredentials.newBuilder().build();
        }
    }

    @Bean
    FirebaseApp firebaseApp(GoogleCredentials credentials) {
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();
            return FirebaseApp.initializeApp(options);
        }
        return FirebaseApp.getInstance();
    }

    @Bean
    FirebaseMessaging firebaseMessaging(FirebaseApp app) {
        return FirebaseMessaging.getInstance(app);
    }

    @Bean
    FcmMessageManager fcmMessageManager(FirebaseMessaging messaging) {
        return new FcmMessageManager(messaging);
    }

    @Bean
    FcmTopicManager fcmTopicManager(FirebaseMessaging messaging) {
        return new FcmTopicManager(messaging);
    }

}
```