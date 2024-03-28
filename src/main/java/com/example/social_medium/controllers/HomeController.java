package com.example.social_medium.controllers;

import com.example.social_medium.models.Profile;
import com.example.social_medium.services.PostService;
import com.example.social_medium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        model.addAttribute("profileService", profileService);

        return "home/index";
    }

    @GetMapping("/profile/{profileId}")
    public String viewProfile(@PathVariable int profileId, Model model){
        Profile profile = profileService.getProfile(profileId);
       model.addAttribute("profile",profile);

       if (profile != null) {
           model.addAttribute("posts", postService.getPostByUserId(profile.getProfileId()));
           return "home/profile";
       } else {
           return "home/profile_not_found";
       }
    }

    @GetMapping("/login")
    public String login(){
        return "home/login";
    }


}
