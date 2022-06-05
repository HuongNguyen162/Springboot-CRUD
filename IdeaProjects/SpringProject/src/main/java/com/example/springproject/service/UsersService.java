package com.example.springproject.service;

import com.example.springproject.exception.ValidationRunTimeException;
import com.example.springproject.model.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UsersService extends Service {

    List<Users> getUsers();
    Users save(Users users);
    Users create(Users users);
    Optional<Users> findById(int id);
    Optional<Users> findByEmail(String email);
    Users update(String id, Users users) throws ValidationRunTimeException;
    void delete(String id);

}
