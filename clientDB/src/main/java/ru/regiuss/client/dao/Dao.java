package ru.regiuss.client.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll();
    T get();
    void save(T t);
    void remove(T t);
    long count();
}
