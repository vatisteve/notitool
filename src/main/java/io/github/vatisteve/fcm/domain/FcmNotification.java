package io.github.vatisteve.fcm.domain;

import com.google.firebase.messaging.AndroidConfig.Priority;
import io.github.vatisteve.design.domain.INotification;

public interface FcmNotification extends INotification {

    String getTitle();
    String getBody();
    String getIcon();
    String getColor();

    default AndroidNotificationData getAndroidNotificationData() {
        return new AndroidNotificationData(Priority.NORMAL, getTitle(), getIcon(), getBody(), getColor());
    }

    default ApnsNotificationData getApnsNotificationData() {
        return new ApnsNotificationData(getTitle(), getBody(), 10);
    }

    default WebNotificationData getWebNotificationData() {
        return new WebNotificationData(getTitle(), getBody(), getIcon());
    }

    public record AndroidNotificationData (Priority priority, String title, String icon, String body, String color) {}
    public record ApnsNotificationData (String title, String body, int badge) {}
    public record WebNotificationData (String title, String body, String icon) {}

}
