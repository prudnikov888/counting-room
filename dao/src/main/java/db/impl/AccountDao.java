package db.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pojos.Account;

/**
 * Created by anpr0915 on 26.09.2016.
 */
@Repository
public class AccountDao extends BaseDao<Account> {

    @Autowired
    public AccountDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
