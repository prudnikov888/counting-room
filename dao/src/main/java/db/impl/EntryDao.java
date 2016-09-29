package db.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pojos.Entry;

/**
 * Created by anpr0915 on 26.09.2016.
 */
@Repository
public class EntryDao extends BaseDao<Entry> {

    @Autowired
    public EntryDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
