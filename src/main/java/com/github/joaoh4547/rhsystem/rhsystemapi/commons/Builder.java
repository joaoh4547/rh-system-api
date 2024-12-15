package com.github.joaoh4547.rhsystem.rhsystemapi.commons;

/**
 * A generic interface for defining builder patterns.
 *
 * @param <T> the type of object to be built by the implementation of this interface
 */
public interface Builder<T> {

    /**
     * Constructs and returns an instance of the type specified by the builder implementation.
     *
     * @return the constructed instance of type T
     */
    T build();

}
