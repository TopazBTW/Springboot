package com.example.backend.entities;

import com.example.backend.enums.Hoststatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostEntity extends BaseEntity {
    private String protocol;
    private String ip;
    private int port;
    private String username;
    private String password;
    private String url;

    @Enumerated(EnumType.STRING)
    private Hoststatus status;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    private List<ModuleEntity> modules;

    }

