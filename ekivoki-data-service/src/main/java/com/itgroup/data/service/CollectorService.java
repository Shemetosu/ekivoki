package com.itgroup.data.service;

import java.util.List;

public interface CollectorService<E> {

    long count();

    List<E> findAll(String queryTail);
}
