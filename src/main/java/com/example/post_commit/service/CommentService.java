package com.example.post_commit.service;

import com.example.post_commit.dto.CommentDTO;
import com.example.post_commit.dto.PostDTO;



public interface CommentService {


    CommentDTO createComment(CommentDTO comment);


    CommentDTO updateComment(CommentDTO commentDTO);

    void deleteComment(Integer id);


}
