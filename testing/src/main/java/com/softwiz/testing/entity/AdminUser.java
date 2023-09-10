package com.softwiz.testing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "AdminUser")

public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "adminId")
    private Long adminId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "admin")
    private List<User> createdUsers = new ArrayList<>();

}
