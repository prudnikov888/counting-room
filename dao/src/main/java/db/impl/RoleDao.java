package db.impl;

import org.hibernate.SessionFactory;
import pojos.Role;

/**
 * Created by anpr0915 on 26.09.2016.
 */
public class RoleDao extends BaseDao<Role> {

    public RoleDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
