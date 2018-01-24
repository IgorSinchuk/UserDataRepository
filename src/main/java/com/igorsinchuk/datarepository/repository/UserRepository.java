package com.igorsinchuk.datarepository.repository;

import com.igorsinchuk.datarepository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
