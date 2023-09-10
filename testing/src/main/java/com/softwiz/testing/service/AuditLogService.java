package com.softwiz.testing.service;

import com.softwiz.testing.dto.UserDTO;
import com.softwiz.testing.entity.AuditLog;
import com.softwiz.testing.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditLogService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    public void logAdminCreation(Long adminId, String entityType) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAdminId(adminId);
        auditLog.setAction("Admin Creation");
        auditLog.setEntityType(entityType);
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }

    public void logUserCreation(Long adminId, String entityType) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAdminId(adminId);
        auditLog.setAction("User Creation");
        auditLog.setEntityType(entityType);
        auditLog.setTimestamp(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }
}
