package com.example.springmvctemplate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.springmvctemplate.DAO.UserDAO;
import com.example.springmvctemplate.model.User;

@Controller
public class UserRegistratationController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/hello")
    public String hello() { return "hello"; }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView userRegistration(@RequestParam("username") String username, @RequestParam("password") String password) {

        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        int counter = userDAO.registerUser(user);

        if (counter > 0) {
            mv.addObject("msg", "User registration successful.");
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("registration");

        return mv;

    }

}
