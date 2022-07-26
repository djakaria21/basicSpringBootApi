package com.bignerdranch.controllers;

import com.bignerdranch.service.PostService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    PostController postController;

    @Mock
    PostService postService;

    @BeforeEach
    public void before() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(postController)
                .build();
    }

    @SneakyThrows
    @Test
    void shouldCallUsersPostController() {
        mockMvc.perform(
                get("/api/user/1/posts")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    //single post
    @SneakyThrows
    @Test
    void shouldCallSinglePostController() {
        mockMvc.perform(
                get("/api/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    //all posts
    @SneakyThrows
    @Test
    void shouldCallAllPostController() {
        mockMvc.perform(
                get("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    //all posts
    @SneakyThrows
    @Test
    void shouldUpdatePostController() {
        mockMvc.perform(
                post("/api/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    //all posts
    @SneakyThrows
    @Test
    void shouldDeletePostController() {
        mockMvc.perform(
                delete("/api/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }
}
