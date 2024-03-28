package com.example.social_medium.services;

import com.example.social_medium.models.Gender;
import com.example.social_medium.models.Profile;
import com.example.social_medium.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public List<Profile> getProfiles(){
        return profileRepository.getProfiles();
    }

    public void createProfile(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender) {
            profileRepository.createProfile(firstName,lastName,email,dateOfBirth,gender);
    }
    public Profile getProfile(int profileId) {
        return profileRepository.getProfile(profileId);
    }


}
