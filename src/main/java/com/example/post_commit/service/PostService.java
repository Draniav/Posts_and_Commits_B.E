package com.example.post_commit.service;

import com.example.post_commit.dto.PostDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public interface PostService {

    PostDTO createPost (PostDTO post);

    List<PostDTO> findAllPosts ();
    PostDTO updatePost(PostDTO postDTO) ;
    void deletePost(Integer id);

}
