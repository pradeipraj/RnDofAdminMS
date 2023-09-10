package com.softwiz.testing.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class AdminUserDTO {

    private Long adminId;
    private String username;
    private String password;
    private List<UserDTO> createdUsers = new ArrayList<>();

    @Override
    public String toString() {
        return "AdminUserDTO{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
