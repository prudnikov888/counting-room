package sv;

import db.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import pojos.User;

/**
 * Created by anpr0915 on 29.09.2016.
 */
public class UserService extends BaseService<User> {

    @Autowired
    public UserService (UserDao userDao) {
        super(userDao);
    }
}
