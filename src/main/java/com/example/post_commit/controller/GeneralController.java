package com.example.post_commit.controller;


import com.example.post_commit.dto.PostDTO;
import com.example.post_commit.service.CommentService;
import com.example.post_commit.service.PostService;
import com.example.post_commit.service.UserLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    private List<PostDTO> findAllPosts(){

        return postService.findAllPosts();
    }

    @PostMapping("save/post")
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        return postService.createPost(postDTO);
    }

    @PutMapping("update/post")
    public PostDTO updatePost(@RequestBody PostDTO postDTO) {
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("delete/post/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }

}
