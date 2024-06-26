package com.example.social_medium.models;
import java.awt.*;
import java.time.LocalDate;

public class Profile {
    private int profileId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String profilePicture;

    public Profile(){

    }

    public Profile(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
            for (Gender g : Gender.values()) {
                if (g.getValue().equalsIgnoreCase(gender)) {
                    this.gender = g;
                    return;
                }
            }
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
