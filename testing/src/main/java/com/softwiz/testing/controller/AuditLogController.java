package com.softwiz.testing.controller;

import com.softwiz.testing.entity.AuditLog;
import com.softwiz.testing.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/auditLogs")

public class AuditLogController {
    @Autowired
    private AuditLogService auditLogService;

    @GetMapping("/{adminId}")
    public List<AuditLog> getAllLogsByAdmin(@PathVariable Long adminId){
        return auditLogService.getAllLogsByAdmin(adminId);
    }
}
