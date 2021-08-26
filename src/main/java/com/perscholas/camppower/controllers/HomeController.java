package com.perscholas.camppower.controllers;

import com.perscholas.camppower.dao.RentalsRepository;
import com.perscholas.camppower.models.Rentals;
import com.perscholas.camppower.models.Users;
import com.perscholas.camppower.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class HomeController {


    @Autowired
    private UsersRepository userRepo;
    @Autowired
    private RentalsRepository rentalRepo;



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

    @GetMapping("/rental")
    public String showRentForm(Model rentModel) {


        Rentals rent = new Rentals();
        rentModel.addAttribute("rental", rent);
        return "rentalForm";
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
    @PostMapping("/process_rental")
    public String processRegister(Rentals rental) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Users userByUsername = userRepo.getUserByUsername(currentPrincipalName);
        long currentId = userByUsername.getId();
        rental.setUsers(userByUsername);
        //System.out.println("the username -->> " + currentPrincipalName + " " + currentId );
        userByUsername.setThisRentList(rental);

        rentalRepo.save(rental);
        userRepo.save(userByUsername);


        return "register_success";
        }


    @GetMapping("/rentals")
    public String listRentals(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Users userByUsername = userRepo.getUserByUsername(currentPrincipalName);
        long currentId = userByUsername.getId();


        List<Rentals> listRentals = rentalRepo.findAllByUsers_Id(currentId);
        model.addAttribute("listRentals", listRentals;

        return "rentalsShow";
    }


}