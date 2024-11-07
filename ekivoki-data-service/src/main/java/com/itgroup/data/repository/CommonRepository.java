package com.itgroup.data.repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface CommonRepository<E> {

    E findById(UUID id);

    boolean existsById(UUID id);

    List<E> findAll(String queryTail);

    List<E> findAll(Collection<UUID> idList);

    E create(E entity);

    E update(E entity);

    long count();

    void remove(UUID id);
}
