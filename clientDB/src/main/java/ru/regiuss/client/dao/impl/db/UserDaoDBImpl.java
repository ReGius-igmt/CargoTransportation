package ru.regiuss.client.dao.impl.db;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.regiuss.client.dao.UserDao;
import ru.regiuss.client.model.User;
import ru.regiuss.client.utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoDBImpl implements UserDao {
    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("From User", User.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User get() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public long count() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("select count(1) from User", Long.class).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<User> getAllPage(int page, int size) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);
            Root<User> root = cq.from(User.class);
            cq.select(root);
            Query<User> query = session.createQuery(cq);
            query.setMaxResults(size);
            query.setFirstResult(size * page);
            return query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
