package sv;

import db.Dao;
import db.impl.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by anpr0915 on 29.09.2016.
 */
public class BaseService<P> implements IService<P> {


    private BaseDao<P> baseDao;

    @Autowired
    public BaseService (BaseDao<P> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void saveOrUpdate(P p) {
        baseDao.saveOrUpdate(p);
    }

    @Override
    public P get(Serializable id) {
        return baseDao.get(id);
    }

    @Override
    public P load(Serializable id) {
        return baseDao.load(id);
    }

    @Override
    public void delete(P p) {
        baseDao.delete(p);
    }
}
