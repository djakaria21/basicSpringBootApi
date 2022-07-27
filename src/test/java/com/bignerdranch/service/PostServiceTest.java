package com.bignerdranch.service;

import com.bignerdranch.controllers.PostController;
import com.bignerdranch.entity.Post;
import com.bignerdranch.entity.Users;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PostServiceTest {

    @Autowired
    PostService postService;

    Post testPost1;
    Post testPost2;
    Post testPost3;
    Post testPost4;
    Post testPost5;

    private Post createPost(Integer id, Integer userId,  String title, String body) {
        return Post.builder().userId(userId).id(id).title(title).body(body).build();
    }

    @BeforeEach
    public void before() {


        testPost1 = createPost(1, 1, "Node is awesome", "Node.js is a JavaScript runtime built on Chrome's V8 JavaScript engine.");
        testPost2 = createPost(2, 1, "Go is awesome", "Go is a compiled programming language that makes it easy to build simple, reliable, and efficient software.");
        testPost3 = createPost(3, 3, "Rails is awesome", "Ruby on Rails is a web application framework written in Ruby under the MIT License.");
        testPost4 = createPost(4, 4, ".NET is awesome", ".NET is a platform-independent programming language developed by Microsoft.");
        testPost5 = createPost(5, 5, "Java is awesome", "Java is a programming language that is used to develop applications for the Internet and enterprise.");
    }

    @Test
    public void testGetAllPostsForUser() {

        postService.save(testPost1);
        postService.save(testPost2);
        postService.save(testPost3);

        Collection<Post> postCollection = postService.getAllPostsForUser(1);

        assert(postCollection.size() == 2);
        assert (postCollection.contains(testPost1));
        assert (postCollection.contains(testPost2));
        assert (!postCollection.contains(testPost3));
    }

    @Test
    public void getPostTest() {

        postService.save(testPost1);
        postService.save(testPost2);
        postService.save(testPost3);


        assert (postService.getPost(1).equals(testPost1));
        assert (postService.getPost(2).equals(testPost2));
        assert (postService.getPost(3).equals(testPost3));
    }

    @Test
    public void getAllPostsTest(){
        postService.save(testPost1);
        postService.save(testPost2);
        postService.save(testPost3);
        postService.save(testPost4);
        postService.save(testPost5);

        Collection<Post> postCollection = postService.getAllPosts();

        assert(postCollection.size() == 5);
        assert(postCollection.contains(testPost1));
        assert(postCollection.contains(testPost2));
        assert(postCollection.contains(testPost3));
        assert(postCollection.contains(testPost4));
        assert(postCollection.contains(testPost5));
    }

    @Test
    public void deletePostTest(){
        postService.save(testPost1);
        postService.save(testPost2);
        postService.save(testPost3);
        postService.save(testPost4);
        postService.save(testPost5);

        postService.delete(1);
        postService.delete(2);
        postService.delete(3);
        postService.delete(4);
        postService.delete(5);

        Collection<Post> postCollection = postService.getAllPosts();

        assert(postCollection.size() == 0);
    }

}
