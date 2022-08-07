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

        // Set<PostDTO> posts = new LinkedHashSet<>();
        // postRepository.findAll();
        var posts = postRepository.findAll();
        var postDTOs = posts.stream().map(post -> mapper.fromEntityToPostDto(post)).toList();
        return postDTOs;


    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        var postOptional = postRepository.findById(postDTO.getId());
        if (postOptional.isPresent()) {
            var postUpdated = postRepository.save(mapper.fromPostDtoToEntity(postDTO));
            var postUpdatedDto = mapper.fromEntityToPostDto(postUpdated);
            return postUpdatedDto;
        }

        throw new IllegalStateException("ERROR the post don´t exist");
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deleteById(id);

    }
}
