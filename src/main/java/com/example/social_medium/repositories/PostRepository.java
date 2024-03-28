package com.example.social_medium.repositories;

import com.example.social_medium.models.Gender;
import com.example.social_medium.models.Post;
import com.example.social_medium.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Post> getPosts(){
        String query ="SELECT  post.*, GROUP_CONCAT(tag.tag_name SEPARATOR ', ')" +
                "  AS tags, profile.* FROM post JOIN profile USING (profile_id)" +
                " LEFT JOIN post_tag ON post.post_id = post_tag.post_id " +
                "LEFT JOIN tag ON post_tag.tag_id = tag.tag_id " +
                "GROUP BY post.post_id " +
                "ORDER BY created_at DESC;";
        RowMapper<Post> rowMapper = new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post post = new Post();
                post.setPostId(rs.getInt("post_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                String tagsString = rs.getString("tags");
                if (tagsString != null){
                    List<String> tags = Arrays.asList(tagsString.split(", "));
                    post.setTags(tags);
                }

                Profile profile = new Profile();
                profile.setProfileId(rs.getInt("profile_id"));
                profile.setFirstName(rs.getString("firstname"));
                profile.setLastName(rs.getString("lastname"));
                profile.setEmail(rs.getString("email"));
                profile.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
                profile.setGender(((rs.getString("gender"))));


                post.setProfile(profile);
                return post;
            }
        };

        return jdbcTemplate.query(query,rowMapper);
    }


    public List<Post> getPostByUserId(int profileId) {
        String query ="SELECT post.*, GROUP_CONCAT(tag.tag_name SEPARATOR ', ')" +
                " AS tags FROM post LEFT JOIN post_tag " +
                "ON post.post_id = post_tag.post_id " +
                "LEFT JOIN tag ON post_tag.tag_id = tag.tag_id " +
                "WHERE profile_id = ? GROUP BY post.post_id ORDER BY post.created_at DESC;";
        RowMapper<Post> rowMapper = new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post post = new Post();
                post.setPostId(rs.getInt("post_id"));
                post.setProfileID(profileId);
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setCreatedAt(rs.getTimestamp("created_At").toLocalDateTime());

                String tagsString = rs.getString("tags");
                if (tagsString != null){
                    List<String> tags = Arrays.asList(tagsString.split(", "));
                    post.setTags(tags);
                }
                return post;
            }
        };
        return jdbcTemplate.query(query, rowMapper, profileId);

    }
}
