package com.example.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class EnvironnementEntity extends BaseEntity {
    private String name;
    private String description;

    @OneToMany(mappedBy = "environnement", fetch = FetchType.LAZY)
    private List<ModuleEntity> modules;
}
