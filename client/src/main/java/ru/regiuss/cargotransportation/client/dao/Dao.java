package ru.regiuss.cargotransportation.client.dao;

import java.util.List;

public interface Dao<T> {
    List<T> getAll(int page, int limit);
}
