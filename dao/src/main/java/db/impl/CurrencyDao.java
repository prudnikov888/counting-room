package db.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojos.Currency;

import java.util.List;

/**
 * Created by anpr0915 on 26.09.2016.
 */
public class CurrencyDao extends BaseDao<pojos.Currency> {

    public CurrencyDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Currency getCurrencyByAbbreviation (String currencyAbbreviation) {
        Session session = getCurrentSession();
        Currency currency = (Currency) session.bySimpleNaturalId(currencyAbbreviation);
        return currency;
    }
}
