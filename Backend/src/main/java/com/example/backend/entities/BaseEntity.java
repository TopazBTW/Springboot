package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private String updatedBy;
    private String createdBy;

    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdate = LocalDateTime.now();
    }
}
