package com.bignerdranch.service;

import com.bignerdranch.entity.Post;
import com.bignerdranch.repositories.PostRepository;
import com.bignerdranch.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Collection<Post> getAllPostsForUser(Integer userId) {

        return postRepository.findAllByUserId(userId);
    }

    public Post getPost(Integer id) {
        return postRepository.findById(id).get();
    }

    public Collection<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Integer id) {
        postRepository.deleteById(id);
    }
}
