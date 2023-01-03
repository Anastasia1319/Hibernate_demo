package com.belhard.hibernate.dao;

import java.util.List;

public interface CrudRepository<T, K> {
    T find (K key);
    List<T> findAll();
//    T create (T entity);
//    T update (T entity);
    void save (T entity);
    boolean delete (K key);
}
