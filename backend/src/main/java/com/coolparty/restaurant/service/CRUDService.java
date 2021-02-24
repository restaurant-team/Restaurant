package com.coolparty.restaurant.service;

import java.util.List;

public interface CRUDService<T> {

    T find(Object id);

    List<T> findAll();

    T create(T t);

    T update(T t);

    void delete(Object id);

}
