package com.softwiz.testing.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class AuditLogDTO {
    private Long logId;
    private Long adminId;
    private String action;
    private String entityType;
    /*private Long entityId;*/
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "AuditLogDTO{" +
                "logId=" + logId +
                ", adminId=" + adminId +
                ", action='" + action + '\'' +
                ", entityType='" + entityType + '\'' +
                /*", entityId=" + entityId +*/
                ", timestamp=" + timestamp +
                '}';
    }
}
