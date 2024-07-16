package com.example.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class UserEntity extends BaseEntity {
    private String username;
    private String password; // Secure Storage? Hashing ?

    @OneToMany(mappedBy = "user")
    private List<RoleEntity> roles;
}
