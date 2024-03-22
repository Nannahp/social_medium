package com.example.social_medium.controllers;

import com.example.social_medium.services.PostService;
import com.example.social_medium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Autowired
    private ProfileService profileService;
  @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("profiles", profileService.getProfiles() );
        model.addAttribute("posts", postService.getPosts() );
        return "home/index";
    }
}
