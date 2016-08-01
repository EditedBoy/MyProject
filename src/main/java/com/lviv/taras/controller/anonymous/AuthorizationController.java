package com.lviv.taras.controller.anonymous;

import com.lviv.taras.entity.User;
import com.lviv.taras.entity.enums.UserRoleEnum;
import com.lviv.taras.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.HttpConstraint;

@Controller
public class AuthorizationController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String openAuthorizationPage() {
        System.out.println("Authorization page");
        return "authorization";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("Authorization Login");
        return "authorization";
    }


    @RequestMapping(value = "/authorization/register", method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRoleEnum.USER);

        this.userService.save(user);
        return "authorization";
    }

    @RequestMapping(value = "/authorization/reset", method = RequestMethod.POST)
    public String resetPassword(@RequestParam String email) {
        System.out.println("Reset password");
        System.out.println("Email - " + email);

        return "authorization";
    }
}
