package com.example.social_medium.models;
import java.time.LocalDateTime;
public class Post {
    private int postId;
    private int profileID;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Post(){

    }

    public Post(int postId, int profileID, String title, String content, LocalDateTime createdAt) {
        this.postId = postId;
        this.profileID = profileID;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
