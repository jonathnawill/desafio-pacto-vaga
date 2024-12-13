package com.desafio.pacto.entities.dto;

import javax.persistence.*;

import com.desafio.pacto.entities.DateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String skillName;
    private Integer experienceYears;
    private DateEntity dateEntity;
}
