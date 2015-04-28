package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by okeynan on 4/16/15.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing Web Store!");
        return "welcome";
    }

    @RequestMapping("/welcome/greeting")
    public String greeting() {
        return "welcome";
    }
}
