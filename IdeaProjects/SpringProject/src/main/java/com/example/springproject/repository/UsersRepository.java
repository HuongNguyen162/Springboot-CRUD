package com.example.springproject.repository;

import com.example.springproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public  interface UsersRepository extends JpaRepository<Users, Integer>{
    List<Users> findAll();
    Optional<Users> findByEmail(String email);
    Optional<Users> findById (Integer id);
    Users save(Users users);
    void deleteById(String id);
}
