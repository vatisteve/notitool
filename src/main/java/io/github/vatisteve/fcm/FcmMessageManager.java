package io.github.vatisteve.fcm;

import com.google.firebase.messaging.*;
import io.github.vatisteve.design.application.MessageManagementResponse;
import io.github.vatisteve.design.application.MessageManager;
import io.github.vatisteve.design.domain.IDevice;
import io.github.vatisteve.design.domain.IDeviceGroup;
import io.github.vatisteve.design.exceptions.NotificationException;
import io.github.vatisteve.fcm.domain.FcmDevice;
import io.github.vatisteve.fcm.domain.FcmNotification;
import io.github.vatisteve.fcm.domain.FcmTopic;

import java.util.List;

/**
 * @author vatisteve
 * @since 0.1.0
 */
public class FcmMessageManager implements MessageManager<FcmNotification, FcmDevice, FcmTopic> {

    private final FirebaseMessaging fcm;
    private final FcmMessageFactory mf;

    public FcmMessageManager(FirebaseMessaging fcm) {
        this.fcm = fcm;
        this.mf = new FcmMessageFactory();
    }

    @Override
    public FcmMessageResponse send(FcmNotification notification, FcmDevice device) throws NotificationException {
        if (!device.isActive()) return new FcmMessageResponse();
        Message message = mf.createMessage(notification, device);
        try {
            String messageId = fcm.send(message);
            return new FcmMessageResponse(messageId);
        } catch (FirebaseMessagingException e) {
            throw new NotificationException(e.getMessage());
        }
    }

    @Override
    public MessageManagementResponse sendMulticast(FcmNotification notification, List<FcmDevice> devices)
            throws NotificationException {
        MulticastMessage message = mf.createMulticastMessage(notification, devices.parallelStream().filter(IDevice::isActive).toList());
        try {
            BatchResponse response = fcm.sendEachForMulticast(message);
            return new FcmMessageResponse(response.getSuccessCount(), response.getFailureCount());
        } catch (FirebaseMessagingException e) {
            throw new NotificationException(e.getMessage());
        }
    }

    @Override
    public MessageManagementResponse sendToTopic(FcmNotification notification, FcmTopic topic)
            throws NotificationException {
        Message message = mf.createMessage(notification, topic);
        try {
            String messageId = fcm.send(message);
            return new FcmMessageResponse(messageId);
        } catch (FirebaseMessagingException e) {
            throw new NotificationException(e.getMessage());
        }
    }

    @Override
    public MessageManagementResponse sendToDeviceGroup(FcmNotification notification, IDeviceGroup<FcmDevice> group)
            throws NotificationException {
        /*
         * The management of device groups and sending messages to device groups is typically done via the app server
         *  using the FCM HTTP v1 API. The Firebase SDKs for client-side platforms such as Android, iOS, and the web
         *  do not provide methods for managing device groups or sending messages to device groups.
         */
        throw new UnsupportedOperationException("Not implement yet!");
    }

}
