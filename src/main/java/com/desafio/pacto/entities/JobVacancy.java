package com.desafio.pacto.entities;

import com.desafio.pacto.entities.listener.EntityCreateUpdateListener;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "JOB_VACANCY")
@EntityListeners(EntityCreateUpdateListener.class)
public class JobVacancy implements Serializable, DateInterface{


    @Id
    @SequenceGenerator(name = " pacto-custom-generator-job_vacancy", allocationSize = 1,  sequenceName = "id_job_vacancy_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacto-custom-generator-job_vacancy")
    @Column(name = "id_job_vacancy", unique = true, nullable = false)
    private Long id;

    private String title;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "JOB_VACANCY_SKILL", joinColumns = @JoinColumn(name = "id_job_vacancy"), inverseJoinColumns = @JoinColumn(name = "id_skill"))
    private List<Skill> requiredSkills = new ArrayList<>();

    @Embedded
    private DateEntity dateEntity;
}
