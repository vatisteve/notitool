package io.github.vatisteve.design.application;

import io.github.vatisteve.design.domain.IDevice;
import io.github.vatisteve.design.domain.INotification;
import io.github.vatisteve.design.domain.ITopic;

import java.util.List;

/**
 * MessageFactory
 *
 * @author      tinhnv
 * @since       Jul 20, 2023
 *
 * @param <N>   the {@link INotification}
 * @param <M>   the message class
 * @param <A>   the multicast message class
 * @param <D>   the {@link IDevice}
 * @param <T>   the {@link ITopic}
 */
public interface MessageFactory<N extends INotification, M, A, D extends IDevice<?, ?>, T extends ITopic<?>> {

    M createMessage(N notification, D device);

    A createMulticastMessage(N notification, List<D> devices);

    M createMessage(N notification, T topic);

}
