package controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojos.User;
import sv.IUserService;

import java.util.List;

/**
 * Created by anpr0915 on 03.10.2016.
 */
@RestController
public class UserRestController {

    @Autowired
    private IUserService<User> userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers () {
        return userService.getAll();
    }

    @RequestMapping(value = "/users/{id}",  method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        return userService.get(id);
    }

}
