package com.example.social_medium.repositories;

import com.example.social_medium.models.Gender;
import com.example.social_medium.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfileRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Profile> getProfiles(){
        String query = "SELECT * FROM profile";
        RowMapper<Profile> rowMapper = new BeanPropertyRowMapper<>(Profile.class);
        return jdbcTemplate.query(query,rowMapper);
    }

    public void createProfile(String firstName, String lastName, String email, LocalDate dateOfBirth, Gender gender) {
        String query = "INSERT INTO profile(firstname, lastname, email, date_of_birth, gender) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(query, firstName, lastName, email, dateOfBirth, gender.toString());
    }
    public Profile getProfile(int profileId) {
        String query ="SELECT * FROM profile WHERE profile_id = ?;";
        RowMapper<Profile> rowMapper = new BeanPropertyRowMapper(Profile.class);
        return jdbcTemplate.queryForObject(query, rowMapper, profileId);
    }

}
