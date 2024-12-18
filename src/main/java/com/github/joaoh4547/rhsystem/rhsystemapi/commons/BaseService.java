package com.github.joaoh4547.rhsystem.rhsystemapi.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T, K> {
    T save(T obj);

    void delete(T obj);

    Page<T> findAll(Pageable pageable);

    T findById(K id);

}
