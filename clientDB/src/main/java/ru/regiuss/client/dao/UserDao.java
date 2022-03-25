package ru.regiuss.client.dao;

import ru.regiuss.client.model.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> getAllPage(int page, int size);
}
