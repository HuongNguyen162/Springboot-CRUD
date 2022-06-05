package com.example.springproject.service;

import com.example.springproject.exception.DublicateRecordException;
import com.example.springproject.exception.InternalServerException;
import com.example.springproject.exception.NotFoundException;
import com.example.springproject.exception.ValidationRunTimeException;
import com.example.springproject.model.Users;
import com.example.springproject.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public abstract class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    //private final UsersRepository usersRepository;
    //private final PasswordEncoder passwordEncoder;

    @Override
    public List<Users> getUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    public Users save(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        this.usersRepository.save(users);
        return users;
    }

    @Override
    public Users create(Users users) {
        //Check id exist
        if(this.findById(users.getId()).isPresent()){
            throw new DublicateRecordException("Id already exist");
        }
        if (this.findByEmail(users.getEmail()).isPresent()){
            throw new DublicateRecordException("Email already exist");
        }
        this.save(users);

        return users;
    }

    @Override
    public Optional<Users> findById(int id) {
        return this.usersRepository.findById(id);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return this.usersRepository.findByEmail(email);
    }

    @Override
    public Users update(String id, Users users) throws ValidationRunTimeException {
        if(!Objects.equals(Integer.parseInt(id), users.getId())) {
            throw new ValidationRunTimeException("Id not match");
        }
        Optional<Users> usersOptional = this.findById(Integer.parseInt(id));
        if(usersOptional.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        try {
            this.save(users);
        } catch(Exception e) {
            throw new InternalServerException("Database error. Can't update user");
        }
        return users;
    }

    @Override
    public void delete(String id) {
        Optional<Users> usersOptional = this.findById(Integer.parseInt(id));
        if (usersOptional.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        this.usersRepository.deleteById(id);
        }
}
