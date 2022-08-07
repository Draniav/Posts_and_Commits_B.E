package com.example.post_commit.dto;


import com.example.post_commit.entity.Post;
import com.example.post_commit.entity.UserLike;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class CommentDTO {

    private Integer id;
    @Size(min=10, max = 255, message = "Error the number of characters must be min 10 max 255")
    private String content;
    private Integer numberOfLikes=0;
    private Post fkPost;//
    private Set<UserLike> userLikes = new LinkedHashSet<>();

}