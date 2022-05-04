package br.fatec.we_can_teach_you.service;

import java.util.List;

public interface ServiceInterface<T> {
    T create(T obj);
    T findById(Long id);
    List<T> findAll();
    boolean update(T obj);
    boolean delete(Long id);
}
