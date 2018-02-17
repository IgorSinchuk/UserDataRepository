package com.igorsinchuk.datarepository.service;

import com.igorsinchuk.datarepository.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<User> getUserById(Integer userId) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }
}
