package sv.impl;

import db.Dao;
import db.impl.EntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojos.Entry;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
@Transactional
public class EntryService extends BaseService<Entry> {

}
