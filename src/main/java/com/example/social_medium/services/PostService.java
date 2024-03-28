package com.example.social_medium.services;

import com.example.social_medium.models.Post;
import com.example.social_medium.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getPosts(){
        return postRepository.getPosts();
    }

    public List<Post> getPostByUserId(int profileId) {
        return postRepository.getPostByUserId(profileId);
    }


}
