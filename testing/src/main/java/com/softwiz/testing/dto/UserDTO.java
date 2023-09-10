package com.softwiz.testing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {
    private Long userId;
    private String email;
    private String password;
    private Boolean isEnable;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isEnable='" + isEnable + '\'' +
                '}';
    }
}
