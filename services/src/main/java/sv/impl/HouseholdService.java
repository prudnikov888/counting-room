package sv.impl;

import db.Dao;
import db.impl.HouseholdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojos.Household;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
@Transactional
public class HouseholdService extends BaseService<Household> {
}
