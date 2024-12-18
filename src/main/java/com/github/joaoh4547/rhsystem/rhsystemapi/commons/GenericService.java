package com.github.joaoh4547.rhsystem.rhsystemapi.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Set;


public abstract class GenericService<T, K> implements BaseService<T, K> {

    @Autowired
    private CacheManager cacheManager;

    private Cache cache;

    private final Set<String> cacheKeys = new HashSet<>();

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
        getCache().evict(extractId(obj));
        evictFindAll();
    }

    private void evictFindAll() {
        for (String cacheKey : cacheKeys) {
            getCache().evict(cacheKey);
        }
        cacheKeys.clear();
    }

    public void onUpdate(T obj) {
        getCache().evict(extractId(obj));
        evictFindAll();
    }

    public void onInsert(T obj) {
        getCache().put(extractId(obj), obj);
        evictFindAll();
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
        String cacheKey = "findAll_" + pageable.getPageNumber() + "_" + pageable.getPageSize();
        cacheKeys.add(cacheKey);
        if (getCache().get(cacheKey) != null) {
            @SuppressWarnings("unchecked")
            Page<T> cachedResult = (Page<T>) cache.get(cacheKey, Page.class);
            if (cachedResult != null) {
                return cachedResult;
            }
        }

        Page<T> result = getRepository().findAll(pageable);
        getCache().put(cacheKey, result);
        return result;
    }

    private Cache getCache() {
        if (cache == null) {
            cache = cacheManager.getCache(getClass().getSimpleName());
        }
        return cache;
    }

    @Override
    public T findById(K id) {
        return getRepository().findById(id).orElse(null);
    }
}
