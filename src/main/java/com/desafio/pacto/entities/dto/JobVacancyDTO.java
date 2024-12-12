package com.desafio.pacto.entities.dto;

import com.desafio.pacto.entities.DateEntity;
import com.desafio.pacto.entities.Skill;
import com.desafio.pacto.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobVacancyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private List<SkillDTO> requiredSkills;
    private Long createdById;
    private DateEntity dateEntity;
}
