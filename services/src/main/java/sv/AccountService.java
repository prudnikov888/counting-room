package sv;

import db.impl.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import pojos.Account;

/**
 * Created by anpr0915 on 29.09.2016.
 */
public class AccountService extends BaseService<Account> {

    @Autowired
    public AccountService (AccountDao accountDao) {
        super(accountDao);
    }
}



