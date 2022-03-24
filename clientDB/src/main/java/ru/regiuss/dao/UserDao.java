package ru.regiuss.dao;

import ru.regiuss.model.User;

import java.util.List;

public interface UserDao extends Dao<User> {
    List<User> getAllPage(int page, int size);
}
