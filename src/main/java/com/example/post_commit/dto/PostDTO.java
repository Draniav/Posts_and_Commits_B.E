package com.example.post_commit.dto;


import com.example.post_commit.entity.Comment;
import com.example.post_commit.entity.UserLike;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class PostDTO {

    private Integer id;
    private String title;
    private String content;
    private Integer numberOfLikes=0;
    private Set<UserLike> userLikes = new LinkedHashSet<>();
    private Set<Comment> comments = new LinkedHashSet<>();
}