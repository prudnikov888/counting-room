package sv.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojos.User;
import sv.IUserService;

/**
 * Created by anpr0915 on 29.09.2016.
 */
@Service
@Transactional
public class UserService extends BaseService<User> implements IUserService<User> {

}
