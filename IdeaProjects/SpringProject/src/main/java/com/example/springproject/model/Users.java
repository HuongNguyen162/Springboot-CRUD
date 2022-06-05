package com.example.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Getter
@Setter

public class Users {
    @Id
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password", length = 225)
    private String password;


}
