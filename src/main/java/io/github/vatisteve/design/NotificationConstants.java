package io.github.vatisteve.design;

public interface NotificationConstants {

                                            // FCM
    int getMaxDevicePerGroup();             // 20
    int getMaxDevicePerMulticast();         // 500
    int getMaxSubscribeDevicePerRequest();  // 1000
    int getMaxSubscribedTopicPerDevice();   // 2000

}
