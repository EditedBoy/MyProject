package com.lviv.taras.service.abstraction;

import java.util.List;


public interface BaseService<T> {

    List<T> findAll();

    void save(T user);

    T getOne(Long id);

    List<T> findAll(Iterable<Long> ids);
}
