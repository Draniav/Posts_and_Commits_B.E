package com.example.post_commit.service;

import com.example.post_commit.dto.CommentDTO;
import com.example.post_commit.dto.CustomMapper;

import com.example.post_commit.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CustomMapper mapper;
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public CommentDTO createComment(CommentDTO comment) {


        return mapper
                .fromEntityToCommentDto(commentRepository
                        .save(mapper.fromCommentDtoToEntity(comment)));
    }

    @Override
    public CommentDTO updateComment(CommentDTO commentDTO) {

        var commentOptional= commentRepository.findById(commentDTO.getId());
        if(commentOptional.isPresent()){
            var commentUpdated= commentRepository.save(mapper.fromCommentDtoToEntity(commentDTO));
            var commentUpdatedDto =mapper.fromEntityToCommentDto(commentUpdated);
            return commentUpdatedDto;
        }

        throw new IllegalStateException("ERROR the commentary don´t exist");
    }


    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
