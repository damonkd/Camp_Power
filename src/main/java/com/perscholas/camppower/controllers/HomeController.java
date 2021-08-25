package com.perscholas.camppower.controllers;

import java.util.*;

import com.perscholas.camppower.models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
      return "home";
    };

    @GetMapping("/register")
    public String showForm(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "registration_form";
    }
}
