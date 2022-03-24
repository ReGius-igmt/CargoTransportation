package ru.regiuss.core;

import ru.regiuss.dao.UserDao;
import ru.regiuss.dao.impl.api.UserDaoAPIImpl;
import ru.regiuss.dao.impl.db.UserDaoDBImpl;

public class ModelFactory {
    public UserDao getUserDao() {
        //return new UserDaoDBImpl();
        return new UserDaoAPIImpl();
    }
}
