import db.impl.AccountDao;
import db.impl.EntryDao;
import db.impl.HouseholdDao;
import db.impl.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pojos.Account;
import pojos.Entry;
import pojos.Household;
import pojos.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by anpr0915 on 25.09.2016.
 */
@ContextConfiguration ("/daoContextTest.xml")
@Transactional
@RunWith (SpringJUnit4ClassRunner.class)

public class DaoTest {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private EntryDao entryDao;

    @Autowired
    private HouseholdDao householdDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void saveEntities() {

        //create household
        Household household = new Household();
        household.setHouseholdName("Prudnikovi");

        //create user
        User user = new User();
        user.setEmail("prudnikov888@gmail.com");
        user.setUserName("prudnikov888");
        user.setPassword("1111");
        user.setHousehold(household);
        List<User> users = new ArrayList<>();
        users.add(user);

        //create accounts
        Account accountFood = new Account();
        accountFood.setAccountName("Food");
        accountFood.setBalance(BigDecimal.valueOf(0d));
        accountFood.setHousehold(household);

        Account accountCash = new Account();
        accountCash.setAccountName("Cash");
        accountCash.setBalance(BigDecimal.valueOf(100d));
        accountCash.setHousehold(household);

        List<Account> accounts = new ArrayList<>();
        accounts.add(accountCash);
        accounts.add(accountFood);

        //create Entry
        Entry entry = new Entry();
        entry.setDate(new Date());
        entry.setSum(BigDecimal.valueOf(20d));
        entry.setDebit(accountFood);
        entry.setCredit(accountCash);
        entry.setUser(user);

        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        user.setEntries(entries);

        household.setAccounts(accounts);
        household.setUsers(users);

        householdDao.saveOrUpdate(household);
        userDao.saveOrUpdate(user);
        accountDao.saveOrUpdate(accountCash);
        accountDao.saveOrUpdate(accountFood);
        entryDao.saveOrUpdate(entry);

        Assert.assertEquals(household, householdDao.get(household.getHouseholdId()));
        Assert.assertEquals(user, userDao.get(user.getUserId()));
        Assert.assertEquals(accountFood, accountDao.get(accountFood.getAccountId()));
        Assert.assertEquals(accountCash, accountDao.get(accountCash.getAccountId()));
        Assert.assertEquals(entry, entryDao.get(entry.getEntryId()));
    }
}
