package com.softwiz.testing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "AuditLog")

public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "logId")
    private Long logId;

    @Column(name = "adminId")
    private Long adminId;

    @Column(name = "action")
    private String action;

    @Column(name = "entityType")
    private String entityType;

    /*@Column(name = "entityId")
    private Long entityId;*/

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

}
