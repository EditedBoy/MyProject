package com.lviv.taras.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactUsController {


    @RequestMapping(value = "/contact-us", method = RequestMethod.GET)
    public String openContactUsPage() {
        System.out.println("Contact Us page");
        return "contact-us";
    }
}
