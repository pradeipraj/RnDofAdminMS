package com.softwiz.testing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "UserTable")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "userId")
    private Long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "isEnable")
    private Boolean isEnable;

    @ManyToOne
    @JoinColumn(name = "adminId")
    private AdminUser admin;

}
