package com.perscholas.camppower.controllers;

import com.perscholas.camppower.models.Users;
import com.perscholas.camppower.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class HomeController {
    @Autowired
    private UsersRepository userRepo;


    @GetMapping("/")
    public String index(){
      return "home";
    };

    @GetMapping("/register")
    public String showForm(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);

//        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
//        model.addAttribute("listProfession", listProfession);

        return "registration_form";
    }

    @PostMapping("/process_register")
    public String processRegister(Users user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        System.out.println("this is user" + user);
        userRepo.save(user);


        return "register_success";
    }



}
