package com.example.post_commit.dto;


import com.example.post_commit.entity.Comment;
import com.example.post_commit.entity.UserLike;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class PostDTO {

    private Integer id;
    @Size(min=5, max = 50, message = "Error the number of characters must be min 5 max 50")
    private String title;
    @Size(min=10, max = 255, message = "Error the number of characters must be min 10 max 255")
    private String content;
    private Integer numberOfLikes=0;
    private Set<UserLike> userLikes = new LinkedHashSet<>();
    private Set<Comment> comments = new LinkedHashSet<>();
}