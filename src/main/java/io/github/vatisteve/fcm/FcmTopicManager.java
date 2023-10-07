package io.github.vatisteve.fcm;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.TopicManagementResponse;
import io.github.vatisteve.design.application.TopicManager;
import io.github.vatisteve.design.domain.IDevice;
import io.github.vatisteve.design.exceptions.NotificationException;
import io.github.vatisteve.fcm.domain.FcmDevice;
import io.github.vatisteve.fcm.domain.FcmTopic;

import java.util.List;

/**
 * @author vatisteve
 * @since 0.1.0
 */
public class FcmTopicManager implements TopicManager<FcmTopic, FcmDevice> {

    private final FirebaseMessaging fcm;

    public FcmTopicManager(FirebaseMessaging fcm) {
        this.fcm = fcm;
    }

    @Override
    public FcmTopicResponse subscribe(FcmTopic topic, FcmDevice device) throws NotificationException {
        if (!device.isActive()) return new FcmTopicResponse(0, 0);
        try {
            TopicManagementResponse response = fcm.subscribeToTopic(List.of(device.getDeviceToken()), topic.getTopicIdentifier());
            return new FcmTopicResponse(response.getSuccessCount(), response.getFailureCount());
        } catch (FirebaseMessagingException e) {
            throw new NotificationException(e.getMessage());
        }
    }

    @Override
    public FcmTopicResponse subscribe(FcmTopic topic, List<FcmDevice> devices) throws NotificationException {
        try {
            TopicManagementResponse response = fcm.subscribeToTopic(devices.parallelStream()
                    .filter(IDevice::isActive).map(IDevice::getDeviceToken).toList(), topic.getTopicIdentifier());
            return new FcmTopicResponse(response.getSuccessCount(), response.getFailureCount());
        } catch (FirebaseMessagingException e) {
            throw new NotificationException(e.getMessage());
        }
    }

    @Override
    public FcmTopicResponse unsubscribe(FcmTopic topic, FcmDevice device) throws NotificationException {
        try {
            TopicManagementResponse response = fcm.unsubscribeFromTopic(List.of(device.getDeviceToken()), topic.getTopicIdentifier());
            return new FcmTopicResponse(response.getSuccessCount(), response.getFailureCount());
        } catch (FirebaseMessagingException e) {
            throw new NotificationException(e.getMessage());
        }
    }

    @Override
    public FcmTopicResponse unsubscribe(FcmTopic topic, List<FcmDevice> devices) throws NotificationException {
        try {
            TopicManagementResponse response = fcm.unsubscribeFromTopic(devices.parallelStream().map(FcmDevice::getDeviceToken).toList(), topic.getTopicIdentifier());
            return new FcmTopicResponse(response.getSuccessCount(), response.getFailureCount());
        } catch (FirebaseMessagingException e) {
            throw new NotificationException(e.getMessage());
        }
    }
}
