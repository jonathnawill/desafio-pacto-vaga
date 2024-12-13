package com.desafio.pacto.entities.dto;

import com.desafio.pacto.entities.DateEntity;
import com.desafio.pacto.entities.enums.CandidacyStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidacyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private JobVacancyDTO jobVacancy;
    private UserDTO user;
    private String status;
    private DateEntity dateEntity;
}
