package com.desafio.pacto.entities;

import com.desafio.pacto.entities.listener.EntityCreateUpdateListener;
import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "SKILL")
@EntityListeners(EntityCreateUpdateListener.class)
public class Skill implements Serializable, DateInterface {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "pacto-custom-generator-skill", allocationSize = 1, sequenceName = "id_skill_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacto-custom-generator-skill")
    @Column(name = "ID_SKILL", unique = true, nullable = false)
    private Long id;

    @Column(name = "SKILL_NAME", unique = true, nullable = false)
    private String skillName;

    @Column(name = "EXPERIENCE_YEARS", nullable = false)
    private Integer experienceYears;

    @Embedded
    private DateEntity dateEntity;
}

