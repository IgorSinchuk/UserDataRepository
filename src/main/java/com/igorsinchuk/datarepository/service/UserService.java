package com.igorsinchuk.datarepository.service;

import com.igorsinchuk.datarepository.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    ResponseEntity<User> getUserById(Integer userId);
    User createUser(User user);
}
