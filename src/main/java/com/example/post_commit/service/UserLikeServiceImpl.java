package com.example.post_commit.service;

import com.example.post_commit.dto.CustomMapper;
import com.example.post_commit.dto.UserLikeDTO;
import com.example.post_commit.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikeServiceImpl implements UserLikeService{

    @Autowired
    private CustomMapper mapper;

    @Autowired
    private UserLikeRepository userLikeRepository;




    @Override
    public UserLikeDTO createUser(UserLikeDTO userLikeDTO) {
        return mapper
                .fromEntityToUserLikeDto(userLikeRepository
                        .save(mapper.fromUserLikeDtoToEntity(userLikeDTO)));
    }

    @Override
    public UserLikeDTO findUser(UserLikeDTO userLikeDTO) {
        return null;
    }

    @Override
    public UserLikeDTO createLike() {

        return null;
    }

    @Override
    public UserLikeDTO deleteLike() {
        return null;
    }

    @Override
    public void deleteUserLike(Integer id) {

    }
}
