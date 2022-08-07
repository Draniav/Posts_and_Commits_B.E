package com.example.post_commit.service;

import com.example.post_commit.dto.CustomMapper;
import com.example.post_commit.dto.PostDTO;
import com.example.post_commit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private CustomMapper mapper;

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostDTO createPost(PostDTO post) {
        return mapper
                .fromEntityToPostDto(postRepository
                        .save(mapper.fromPostDtoToEntity(post)));
    }

    @Override
    public List<PostDTO> findAllPosts() {
        var posts = postRepository.findAll();
        var postDTOs = posts.stream().map(post -> mapper.fromEntityToPostDto(post)).toList();
        return postDTOs;


    }

    @Override
    public PostDTO updatePost(PostDTO newPost) {
        var oldPost = postRepository.findById(newPost.getId());
        if (oldPost.isPresent()) {
            var updatedPost = mapper.updateExistingPost(oldPost.get(), newPost);
            var savedPost = postRepository.save(updatedPost);
            return mapper.fromEntityToPostDto(savedPost);
        }

        throw new IllegalStateException("ERROR the post don´t exist");
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
