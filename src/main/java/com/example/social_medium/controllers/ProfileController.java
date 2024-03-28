package com.example.social_medium.controllers;

import com.example.social_medium.models.Gender;
import com.example.social_medium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/create_profile")
    public String createProfile(){
        return "home/create_profile";
    }

    @PostMapping("/new_profile")
    public String createProfile(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam LocalDate dateOfBirth, @RequestParam Gender gender){
        profileService.createProfile(firstName,lastName,email,dateOfBirth,gender);
        return ("redirect:/");
    }





}
