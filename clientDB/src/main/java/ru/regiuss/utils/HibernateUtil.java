package ru.regiuss.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.regiuss.model.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            ServiceRegistry serviceRegistry = null;
            try {
                Configuration cfg = new Configuration();
                cfg.addAnnotatedClass(User.class);
                cfg.configure();
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
                sessionFactory = cfg.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                e.printStackTrace();
                if(serviceRegistry != null)StandardServiceRegistryBuilder.destroy(serviceRegistry);
            }
        }
        return sessionFactory;
    }
}
