package com.example.backend.DTOS;


import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)

@Data

public class UserDTO extends BaseDTO {
    private String username;
    private String password;

}
