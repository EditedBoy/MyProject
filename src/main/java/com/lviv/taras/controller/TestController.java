package com.lviv.taras.controller;

import com.lviv.taras.entity.User;
import com.lviv.taras.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String showAddUserForm() {
        return "add-user";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {//String user
        System.out.println(user.toString());

        this.userService.save(user);
        return  "index";//"redirect:/"
    }
}
