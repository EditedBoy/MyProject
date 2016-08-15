package com.lviv.taras.controller.admin;

import com.lviv.taras.entity.User;
import com.lviv.taras.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserListController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user-list", method = RequestMethod.GET)
    public String getUserListPage() {
        return "user-list";
    }


    @ResponseBody
    @RequestMapping(value = "/user-list/getAllUsers", method = RequestMethod.POST, produces = "application/json")
    public List<User> getUserList() {
        System.out.println("getUserList");
        return this.userService.findAll();
    }
}
