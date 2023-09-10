package com.softwiz.testing.controller;

import com.softwiz.testing.dto.AdminUserDTO;
import com.softwiz.testing.service.AdminUserService;
import com.softwiz.testing.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")

public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AuditLogService auditLogService;

    @PostMapping("/adminRegister")
    public ResponseEntity<?> adminRegister(@RequestBody AdminUserDTO adminUserDTO){
        adminUserService.registerAdminUser(adminUserDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUSer(@PathVariable Long userId){
        adminUserService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted:" + userId, HttpStatus.OK);
    }
}
