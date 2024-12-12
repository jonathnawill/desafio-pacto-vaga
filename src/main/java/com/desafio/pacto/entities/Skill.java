package com.desafio.pacto.entities;

import com.desafio.pacto.entities.listener.EntityCreateUpdateListener;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "SKILL")
@EntityListeners(EntityCreateUpdateListener.class)
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @SequenceGenerator(name = "pacto-custom-generator-skill", allocationSize = 1, sequenceName = "id_skill_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacto-custom-generator-skill")
    @Column(name = "id_skill", unique = true, nullable = false)
    private Long skillId;

    @Column(name = "skill_name", unique = true, nullable = false)
    private String skillName;

    @Column(name = "experience_years", nullable = false)
    private Integer experienceYears;
}
