package com.icl.icl.core.generic.service;

import com.icl.icl.core.generic.dao.GenericDao;
import java.util.List;

public interface GenericService<T, C, D> extends GenericDao<T, C> {
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