package db.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pojos.User;

/**
 * Created by anpr0915 on 26.09.2016.
 */
@Repository
public class UserDao extends BaseDao<User> {

    @Autowired
    public UserDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
