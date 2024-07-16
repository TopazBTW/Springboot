package com.example.backend.DTOS;


import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data

public class RoleDTO extends BaseDTO {
    private String name;
    private String description;

}
