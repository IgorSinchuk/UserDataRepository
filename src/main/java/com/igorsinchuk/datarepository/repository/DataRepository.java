package com.igorsinchuk.datarepository.repository;

import com.igorsinchuk.datarepository.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<UserData, Long>{
}
