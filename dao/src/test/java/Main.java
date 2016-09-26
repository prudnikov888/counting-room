import db.impl.CurrencyDao;
import db.impl.EntryDao;
import db.impl.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.*;
import utils.HibernateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anpr0915 on 25.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        //get sessionFactory
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //save currency
        Currency currency = new Currency();
        currency.setCurrencyFullName("American dollar");
        currency.setCurrencyAbbreviation("USD");

        CurrencyDao currencyDao = new CurrencyDao(sessionFactory);
        Transaction tr1 = sessionFactory.getCurrentSession().beginTransaction();
        currencyDao.saveOrUpdate(currency);
        tr1.commit();

        //save user with list of roles
        User user = new User();
        user.setEmail("prudnikov888@gmail.com");
        user.setUserName("prudnikov888");
        user.setPassword("1111");
        Role role = new Role();
        role.setRoleName("Admin");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        UserDao userDao = new UserDao(sessionFactory);
        Transaction tr2 = sessionFactory.getCurrentSession().beginTransaction();
        userDao.saveOrUpdate(user);
        tr2.commit();

        //save new entry
        Account accountA = new Account();
        accountA.setCurrency(currency);
        accountA.setAccountName("Food");
        accountA.setBalance(BigDecimal.valueOf(20d));

        Account accountB = new Account();
        accountB.setCurrency(currency);
        accountB.setAccountName("Cash");
        accountB.setBalance(BigDecimal.valueOf(100d));

        Category category = new Category();
        category.setCategoryName("Household expenses");

        accountA.setCategory(category);
        accountB.setCategory(category);

        Entry entry = new Entry();
        entry.setDate(new Date());
        entry.setCurrency(currency);
        entry.setSum(BigDecimal.valueOf(20d));
        entry.setDebit(accountA);
        entry.setCredit(accountB);

        accountA.setUser(user);
        accountB.setUser(user);
        category.setUser(user);
        entry.setUser(user);

        EntryDao entryDao = new EntryDao(sessionFactory);
        Transaction tr3 = sessionFactory.getCurrentSession().beginTransaction();
        entryDao.saveOrUpdate(entry);
        tr3.commit();
    }
}
