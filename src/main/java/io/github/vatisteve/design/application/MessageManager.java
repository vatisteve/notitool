package io.github.vatisteve.design.application;

import io.github.vatisteve.design.domain.IDevice;
import io.github.vatisteve.design.domain.IDeviceGroup;
import io.github.vatisteve.design.domain.INotification;
import io.github.vatisteve.design.domain.ITopic;
import io.github.vatisteve.design.exceptions.NotificationException;

import java.util.List;

/**
 * MessageManager
 *
 * @author      tinhnv
 * @since       Jul 16, 2023
 *
 * @param <N>   the {@link INotification}
 * @param <D>   the {@link IDevice}
 * @param <T>   the {@link ITopic}
 */
public interface MessageManager<N extends INotification, D extends IDevice<?, ?>, T extends ITopic<?>> {

    MessageManagementResponse send(N notification, D device) throws NotificationException;

    MessageManagementResponse sendMulticast(N notification, List<D> devices) throws NotificationException;

    MessageManagementResponse sendToTopic(N notification, T topic) throws NotificationException;

    MessageManagementResponse sendToDeviceGroup(N notification, IDeviceGroup<D> group) throws NotificationException;

}
