package db.impl;

import org.hibernate.SessionFactory;
import pojos.Account;

/**
 * Created by anpr0915 on 26.09.2016.
 */
public class AccountDao extends BaseDao<Account> {

    public AccountDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
