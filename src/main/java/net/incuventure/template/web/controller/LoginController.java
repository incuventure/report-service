package net.incuventure.template.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model) {

        model.addAttribute("message", "show accounting stuff");

        return "login/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(ModelMap model) {

        System.out.println(model.toString());
        return "login/login";
    }

}
