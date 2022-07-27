package com.bignerdranch.service;

import com.bignerdranch.entity.Users;
import com.bignerdranch.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public  Collection<Users> getAllUsers() {
    return userRepository.findAll();
    }


    public Users getUser(Integer id) {
    return userRepository.findById(id).orElse(null);
    }

    public Users save(Users users) {
    return userRepository.save(users);

    }

    public Users update(Integer id, Users users) {
    users.setId(id);
    return userRepository.save(users);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
