package com.practice.petclinic.services;

import java.util.Set;

/**
 * Used as a base implementation for all services offering common operations.
 *
 * @param <T> type
 * @param <ID> id
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
