package db.impl;

import db.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.usertype.ParameterizedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by anpr0915 on 26.09.2016.
 */
@Repository
public class BaseDao<P> implements Dao<P> {

    private SessionFactory sessionFactory;

    @Autowired
    public BaseDao (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(P p) {
        Session session = getCurrentSession();
        session.saveOrUpdate(p);
    }

    @Override
    public P get(Serializable id) {
        Session session = getCurrentSession();
        P p = (P) session.get(getPersistentClass(), id);
        return p;
    }

    @Override
    public P load(Serializable id) {
        Session session = getCurrentSession();
        P p = (P) session.load(getPersistentClass(), id);
        return p;
    }

    @Override
    public void delete(P p) {
        Session session = getCurrentSession();
        session.delete(p);
    }

    private Class getPersistentClass() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getClass();
    }
}
