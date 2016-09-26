package db.impl;

import org.hibernate.SessionFactory;
import pojos.Category;

/**
 * Created by anpr0915 on 26.09.2016.
 */
public class CategoryDao extends BaseDao<Category> {

    public CategoryDao (SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
