package sv.impl;

import db.Dao;
import db.impl.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.IService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
@Transactional
public class BaseService<P> implements IService<P> {

    @Autowired
    protected BaseDao<P> baseDao;

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

    @Override
    public List<P> getAll() {
        return baseDao.getAll();
    }
}
