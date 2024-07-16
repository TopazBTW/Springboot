package com.example.backend.DTOS;


import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data

public class HostDTO extends BaseDTO {
    private String protocol;
    private String ip;
    private int port;
    private String username;
    private String password;
    private String url;

}

