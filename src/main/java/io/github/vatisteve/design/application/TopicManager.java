package io.github.vatisteve.design.application;

import io.github.vatisteve.design.domain.IDevice;
import io.github.vatisteve.design.domain.ITopic;
import io.github.vatisteve.design.exceptions.NotificationException;

import java.util.List;

/**
 *  TopicManager
 *
 * @author      tinhnv
 * @since       Jul 16, 2023
 *
 * @param <T>   the {@link ITopic}
 * @param <D>   the {@link IDevice}
 */
public interface TopicManager<T extends ITopic<?>, D extends IDevice<?, ?>> {

    TopicManagementResponse subscribe(T topic, D device) throws NotificationException;

    TopicManagementResponse subscribe(T topic, List<D> devices) throws NotificationException;

    TopicManagementResponse unsubscribe(T topic, D device) throws NotificationException;

    TopicManagementResponse unsubscribe(T topic, List<D> devices) throws NotificationException;

}
