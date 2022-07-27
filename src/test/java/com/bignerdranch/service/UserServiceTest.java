package com.bignerdranch.service;


import com.bignerdranch.entity.Users;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    Users testUsers1;
    Users testUsers2;
    Users testUsers3;
    Users testUsers4;

    //helper method to create users for testing
    private Users createUser(Integer id, String name, String email, String expertise) {
        return Users.builder().id(id).name(name).email(email).expertise(expertise).build();
    }

    @BeforeEach
    public void before() {
        testUsers1 = createUser(1, "Ryan Dahl", "node41yfe@example.com", "Node");
        testUsers2 = createUser(2, "Rob Pike", "gofarther@example.com", "Go");
        testUsers3 = createUser(3, "DHH", "magic@example.com", "Rails");
        testUsers4 = createUser(4, "John Watkins", "jwats@example.com", ".NET");

    }

    @Test
    void getAllUsersTest() {
        userService.save(testUsers1);
        userService.save(testUsers2);
        userService.save(testUsers3);
        userService.save(testUsers4);

        Collection<Users> usersCollection = userService.getAllUsers();

        assert(usersCollection.size() == 4);
        assert(usersCollection.contains(testUsers1));
        assert(usersCollection.contains(testUsers2));
        assert(usersCollection.contains(testUsers3));
        assert(usersCollection.contains(testUsers4));
    }

    @Test
    void getUserTest() {
        userService.save(testUsers1);
        userService.save(testUsers2);
        userService.save(testUsers3);
        userService.save(testUsers4);

        Users users1 = userService.getUser(1);
        assert(users1.equals(testUsers1));
        Users users2 = userService.getUser(2);
        assert(users2.equals(testUsers2));
        Users users3 = userService.getUser(3);
        assert(users3.equals(testUsers3));
        Users users4 = userService.getUser(4);
        assert(users4.equals(testUsers4));

    }

    @Test
    void updateUserTest() {
        userService.save(testUsers1);
        assert (userService.getUser(1).equals(testUsers1));
        Users updatedUsers = createUser(1, "Ryan Dahl", "blah@blah.com", "Node");
        userService.update(1, updatedUsers);
        assert (userService.getUser(1).equals(updatedUsers));
    }

    @Test
    void deleteUserTest(){
        userService.save(testUsers1);
        userService.save(testUsers2);
        userService.save(testUsers3);
        userService.save(testUsers4);
        assert(userService.getAllUsers().size() == 4);
        userService.delete(1);
        assert(userService.getAllUsers().size() == 3);
        assert(!userService.getAllUsers().contains(testUsers1));
    }


}
