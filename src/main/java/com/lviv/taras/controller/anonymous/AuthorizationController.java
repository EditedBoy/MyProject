package com.lviv.taras.controller.anonymous;

import com.lviv.taras.entity.User;
import com.lviv.taras.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String openAuthorizationPage() {
        System.out.println("Authorization page");
        return "authorization";
    }

    @RequestMapping(value = "/authorization/login", method = RequestMethod.POST)
    public void login(@RequestParam String email, @RequestParam String password) {
        System.out.println("Login");
        System.out.println("Email - " + email);
        System.out.println("Password - " + password);
    }

    @RequestMapping(value = "/authorization/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        System.out.println("Registration");
        System.out.println(user.toString());

        this.userService.save(user);
    }

    @RequestMapping(value = "/authorization/reset", method = RequestMethod.POST)
    public void resetPassword(@RequestParam String email) {
        System.out.println("Reset password");
        System.out.println("Email - " + email);
    }
}
