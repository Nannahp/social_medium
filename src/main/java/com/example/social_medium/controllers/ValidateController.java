package com.example.social_medium.controllers;

import com.example.social_medium.models.Profile;
import com.example.social_medium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ValidateController {
    @Autowired
    ProfileService profileService;

    @PostMapping("/validate")
    public String validate(Model model, RedirectAttributes redirectAttributes, @RequestParam String firstname, @RequestParam String lastname) {
        List<Profile> profiles = profileService.getProfiles();
        boolean profileFound = false;
        for (Profile profile : profiles) {
            if (profile.getFirstName().equalsIgnoreCase(firstname) &&
                    profile.getLastName().equalsIgnoreCase(lastname)) {
                profileFound = true;
                break; //i know i know
            }
        }
        if (profileFound) {
            redirectAttributes.addFlashAttribute("loggedIn", true); // Add loggedIn attribute for redirect
            return "redirect:/";
        } else {
            model.addAttribute("message", "User doesn't exist!");
            return "home/login";
        }
    }
}
