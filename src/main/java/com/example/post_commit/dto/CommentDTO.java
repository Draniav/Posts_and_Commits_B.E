package com.example.post_commit.dto;


import com.example.post_commit.entity.Post;
import com.example.post_commit.entity.UserLike;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class CommentDTO {

    private Integer id;
    private String content;
    private Integer numberOfLikes=0;
    private Post fkpost;//
    private Set<UserLike> userLikes = new LinkedHashSet<>();

}