package db.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pojos.Household;

/**
 * Created by anpr0915 on 28.09.2016.
 */
@Repository
public class HouseholdDao extends BaseDao<Household> {

    @Autowired
    public HouseholdDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
