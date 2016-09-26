package db.impl;

import org.hibernate.SessionFactory;
import pojos.User;

/**
 * Created by anpr0915 on 26.09.2016.
 */
public class UserDao extends BaseDao<User> {

    public UserDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
