package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import pojos.User;
import sv.UserService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by anpr0915 on 03.10.2016.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
    public String showUsers (ModelMap modelMap) {
        List<User> users = userService.getAll();
        modelMap.addAttribute("allUsers", users);
        return "showUsers";
    }
}
