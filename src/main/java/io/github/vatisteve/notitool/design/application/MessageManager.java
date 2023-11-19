package io.github.vatisteve.notitool.design.application;

import io.github.vatisteve.notitool.design.domain.IDevice;
import io.github.vatisteve.notitool.design.domain.IDeviceGroup;
import io.github.vatisteve.notitool.design.domain.INotification;
import io.github.vatisteve.notitool.design.domain.ITopic;
import io.github.vatisteve.notitool.design.exceptions.NotificationException;

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

    /**
     * Send a message to specific device
     * @param notification the {@link INotification}
     * @param device the {@link IDevice}
     * @return {@link MessageManagementResponse} model, which store the response from push service
     * @throws NotificationException if any error occurred when pushing
     */
    MessageManagementResponse send(N notification, D device) throws NotificationException;

    /**
     * Send a message to a list of device
     * @param notification the {@link INotification}
     * @param devices a list of {@link IDevice}
     * @return {@link MessageManagementResponse} model, which store the response from push service
     * @throws NotificationException if any error occurred when pushing
     */
    MessageManagementResponse sendMulticast(N notification, List<D> devices) throws NotificationException;

    /**
     * Send a message to specific registration topic
     * @param notification the {@link INotification}
     * @param topic the {@link ITopic}
     * @return {@link MessageManagementResponse} model, which store the response from push service
     * @throws NotificationException if any error occurred when pushing
     */
    MessageManagementResponse sendToTopic(N notification, T topic) throws NotificationException;

    /**
     * Send a message to group of device
     * @param notification the {@link INotification}
     * @param group the {@link IDeviceGroup}
     * @return {@link MessageManagementResponse} model, which store the response from push service
     * @throws NotificationException if any error occurred when pushing
     */
    MessageManagementResponse sendToDeviceGroup(N notification, IDeviceGroup<D> group) throws NotificationException;

}
