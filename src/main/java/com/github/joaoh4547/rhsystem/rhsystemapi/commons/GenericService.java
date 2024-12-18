package com.github.joaoh4547.rhsystem.rhsystemapi.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<T, K> implements BaseService<T, K> {

    public abstract JpaRepository<T, K> getRepository();


    protected void validate(T obj) {
    }

    protected void validateInsert(T obj) {
    }

    protected void validateUpdate(T obj) {
    }

    protected void validateDelete(T obj) {
    }

    public void onDelete(T obj) {
    }

    public void onUpdate(T obj) {
    }

    public void onInsert(T obj) {
    }

    protected abstract K extractId(T obj);

    @Override
    public T save(T obj) {
        validate(obj);
        boolean exists = false;
        K key = extractId(obj);
        if (key == null || !getRepository().existsById(key)) {
            validateInsert(obj);
        } else {
            exists = true;
            validateUpdate(obj);
        }
        T persisted = getRepository().save(obj);
        if (exists) {
            onUpdate(persisted);
        } else {
            onInsert(persisted);
        }
        return persisted;
    }

    @Override
    public void delete(T obj) {
        validateDelete(obj);
        getRepository().delete(obj);
        onDelete(obj);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public T findById(K id) {
        return getRepository().findById(id).orElse(null);
    }
}
