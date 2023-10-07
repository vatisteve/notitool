package io.github.vatisteve.design.domain;

/**
 * ICorrespondent
 *
 * @author      tinhnv
 * @since       Jul 20, 2023
 *
 * @param <T>   the correspondent identifier type
 */
public interface ICorrespondent<T> {

    T getCorrespondentIdentifier();

}