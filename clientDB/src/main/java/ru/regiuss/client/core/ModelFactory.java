package ru.regiuss.client.core;

import ru.regiuss.client.dao.UserDao;
import ru.regiuss.client.dao.impl.api.UserDaoAPIImpl;

public class ModelFactory {
    public UserDao getUserDao() {
        //return new UserDaoDBImpl();
        return new UserDaoAPIImpl();
    }
}
