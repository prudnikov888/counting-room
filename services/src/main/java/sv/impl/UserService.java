package sv.impl;

import db.Dao;
import db.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojos.User;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
@Transactional
public class UserService extends BaseService<User> {

}
