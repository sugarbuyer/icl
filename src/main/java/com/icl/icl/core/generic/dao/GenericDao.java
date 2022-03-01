package com.icl.icl.core.generic.dao;

import java.util.List;

public interface GenericDao<T, C> {
    /** Entity **/
    void insert(T entity);
    void update(T entity);
    void delete(T entity);
    T detail(T entity);

    /** List **/
    List<T> list(C criterion);

    /** Count **/
    Integer searchCount(C criterion);
}