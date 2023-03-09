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

    @Value("${exemple.valor}")
    String valor;

    private List<String> llista;
    @Autowired
    private GreetingController(List<String> llista){
        this.llista = llista;
    }

    @GetMapping
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        llista.add(name);
        model.addAttribute("names", llista);
        model.addAttribute("valor",valor);
        return "greeting";
    }

}
