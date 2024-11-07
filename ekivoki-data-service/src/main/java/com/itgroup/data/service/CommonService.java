package com.itgroup.data.service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface CommonService<R, C, U> extends CollectorService<R> {

    R findById(UUID id);

    List<R> findAll(Collection<UUID> idList);

    R create(C dto);

    R update(U dto);

    void remove(UUID id);
}
