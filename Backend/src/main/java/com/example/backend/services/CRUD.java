package com.example.backend.services;

import com.example.backend.entities.BaseEntity;

import java.util.List;

public interface CRUD<T extends BaseEntity> {
    T create(T entity);
    void delete(T entity);
    T modify(T entity);
    List<T> findAll();
    T findById(Long id);
}
