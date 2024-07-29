package io.github.vatisteve.notitool.fcm.domain;

import com.google.firebase.messaging.AndroidConfig.Priority;
import io.github.vatisteve.notitool.design.domain.INotification;

/**
 * @author vatisteve
 * @since 0.1.0
 */
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

    record AndroidNotificationData (Priority priority, String title, String icon, String body, String color) {}
    record ApnsNotificationData (String title, String body, int badge) {}
    record WebNotificationData (String title, String body, String icon) {}

}
