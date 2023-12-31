package com.softwiz.testing.service;

import com.softwiz.testing.dto.AdminUserDTO;
import com.softwiz.testing.dto.UserDTO;
import com.softwiz.testing.entity.AdminUser;
import com.softwiz.testing.entity.User;
import com.softwiz.testing.repository.AdminUserRepository;
import com.softwiz.testing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuditLogService auditLogService;

    public void registerAdminUser(AdminUserDTO adminUserDTO) {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(adminUserDTO.getUsername());
        adminUser.setPassword(adminUserDTO.getPassword());
        adminUserRepository.save(adminUser);
        auditLogService.addLog(adminUser.getAdminId(),"Admin Creation", "Admin User");

        // Create users and associate them with the admin
            List<UserDTO> createdUsers = adminUserDTO.getCreatedUsers();
            if (createdUsers != null && !createdUsers.isEmpty()) {
                for (UserDTO userDTO : createdUsers) {
                    User user = new User();
                    user.setEmail(userDTO.getEmail());
                    user.setPassword(userDTO.getPassword());
                    user.setIsEnable(userDTO.getIsEnable());
                    user.setAdmin(adminUser);
                    userRepository.save(user);
                    auditLogService.addLog(adminUser.getAdminId(),"User Creation", "User");
                }
            }

    }

    public void deleteUser(Long userId) {

        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            auditLogService.addLog(userId, "User Deletion", "User");
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}



