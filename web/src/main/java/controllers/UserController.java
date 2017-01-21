package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import pojos.User;
import org.springframework.web.bind.annotation.RequestMapping;
import sv.IService;
import sv.impl.UserService;

import java.util.List;

/**
 * Created by anpr0915 on 03.10.2016.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IService<User> userService;

    @RequestMapping("/show")
    public String showUsers (ModelMap modelMap) {
        List<User> users = userService.getAll();
        modelMap.addAttribute("allUsers", users);
        return "showUsers";
    }
}
