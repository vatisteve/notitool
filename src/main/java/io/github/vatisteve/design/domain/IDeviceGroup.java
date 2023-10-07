package io.github.vatisteve.design.domain;

import java.util.List;

/**
 *  IDeviceGroup
 *
 * @author      tinhnv
 * @since       Jul 22, 2023
 *
 * @param <D>   the {@link IDevice}
 */
public interface IDeviceGroup<D extends IDevice<?, ?>> {

    List<D> getDevices();

}
