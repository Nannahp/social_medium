package com.example.social_medium.models;

public enum Gender {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");


    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return name(); // Return the name of the enum value
    }
}
