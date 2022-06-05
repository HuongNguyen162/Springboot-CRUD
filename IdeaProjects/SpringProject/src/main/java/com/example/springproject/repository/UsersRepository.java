package com.example.springproject.repository;

import com.example.springproject.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public  interface UsersRepository extends JpaRepository<Users, Integer>{
    List<Users> findAll();
    Optional<Users> findByEmail(String email);
    Optional<Users> findById (Integer id);
    Users save(Users users);
    void deleteById(String id);
}
