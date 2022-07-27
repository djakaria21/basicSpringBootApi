package com.bignerdranch.controllers;

import com.bignerdranch.entity.Post;
import com.bignerdranch.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/posts")
public class PostController {

    @Autowired
    private final PostService postService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Collection<Post>> getAllPostsForUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(postService.getAllPostsForUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @GetMapping
    public ResponseEntity<Collection<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Post> createPost(@PathVariable Integer id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id) {
        postService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
