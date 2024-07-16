package com.example.backend.DTOS;


import lombok.Data;

import java.time.LocalDateTime;

@Data

public class BaseDTO {
    private Long id;
    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;
    private String updatedBy;
    private String createdBy;
}
