package com.example.post_commit.controller;


import com.example.post_commit.dto.PostDTO;
import com.example.post_commit.service.CommentService;
import com.example.post_commit.service.PostService;
import com.example.post_commit.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class GeneralController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserLikeService userLikeService;


    @GetMapping("get/all/posts")
    private List<PostDTO> findAllPosts() {

        return postService.findAllPosts();
    }

    @PostMapping("save/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDTO postDTO, BindingResult result) {

        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.ACCEPTED);
    }

    @PutMapping("update/post")
    public ResponseEntity<?> updatePost(@Valid @RequestBody PostDTO postDTO, BindingResult result) {
        return new ResponseEntity<>(postService.updatePost(postDTO),HttpStatus.OK);
    }

    @DeleteMapping("delete/post/{id}")
    public void deletePost(@Valid @PathVariable Integer id, BindingResult result) {
        postService.deletePost(id);
    }

}
