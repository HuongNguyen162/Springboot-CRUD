package com.example.springproject.controller;

import com.example.springproject.exception.ValidationRunTimeException;
import com.example.springproject.model.Users;
import com.example.springproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService userService;

    @GetMapping("")
    public List<Users> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable String id) {
        return this.userService.findById(Integer.parseInt(id)).orElse(null);
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public Users addUser(@RequestBody Users users) {
        return this.userService.create(users);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable String id, @RequestBody Users users) throws ValidationRunTimeException {
        return this.userService.update(id, users);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        this.userService.delete(id);
    }
}
