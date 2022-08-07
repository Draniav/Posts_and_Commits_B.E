package com.example.post_commit.dto;


import com.example.post_commit.entity.Comment;
import com.example.post_commit.entity.Post;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class UserLikeDTO {

    private Integer id;
    private String userName;
    private String dni;
    private Set<Comment> comments = new LinkedHashSet<>();
    private Set<Post> posts = new LinkedHashSet<>();
}