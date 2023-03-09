package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(GreetingController.GREETING)
public class GreetingController {

    public static final String GREETING = "/greeting";
    @Autowired
    GreetingService greetingService;

    @GetMapping
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        greetingService.addMessage(name);
        model.addAttribute("names", greetingService.getMessages());
        return "greeting";
    }

}
