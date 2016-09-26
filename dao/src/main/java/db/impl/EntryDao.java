package db.impl;

import org.hibernate.SessionFactory;
import pojos.Entry;

/**
 * Created by anpr0915 on 26.09.2016.
 */
public class EntryDao extends BaseDao<Entry> {

    public EntryDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
