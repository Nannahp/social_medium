package com.example.social_medium.models;

public enum Gender {
    FEMALE,
    MALE,
    OTHER;
    @Override
    public String toString() {
        return name(); // Return the name of the enum value
    }
}
