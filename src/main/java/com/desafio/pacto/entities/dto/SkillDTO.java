package com.desafio.pacto.entities.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillDTO implements Serializable {

    private Long id;
    private String skillName;
    private Integer experienceYears;
}
