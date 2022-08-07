package com.example.post_commit.service;


import com.example.post_commit.dto.UserLikeDTO;



public interface UserLikeService {

    UserLikeDTO createUser (UserLikeDTO userLike);

    UserLikeDTO findUser(UserLikeDTO userLikeDTO);
    UserLikeDTO createLike();
    UserLikeDTO deleteLike();
    void deleteUserLike(Integer id);

}