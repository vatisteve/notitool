package io.github.vatisteve.design.domain;

/**
 *  ITopic
 *
 * @author      tinhnv
 * @since       Jul 22, 2023
 *
 * @param <T>   the topic identifier type
 */
public interface ITopic<T> {

    /**
     * @return topic id
     */
    T getTopicIdentifier();

}
