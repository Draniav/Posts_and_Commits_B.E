package com.example.post_commit.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "number_of_likes", nullable = false)
    private Integer numberOfLikes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_like_has_post",
            joinColumns = @JoinColumn(name = "post_id_post"),
            inverseJoinColumns = @JoinColumn(name = "user_like_id_user_like"))
    private Set<UserLike> userLikes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fkPost", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Comment> comments = new LinkedHashSet<>();


    public void increaseNumberOfLikesInPost(){
        this.numberOfLikes++;
    }

    public void reduceNumberOfLikesInPost(){
        this.numberOfLikes--;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Set<UserLike> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<UserLike> userLikes) {
        this.userLikes = userLikes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}