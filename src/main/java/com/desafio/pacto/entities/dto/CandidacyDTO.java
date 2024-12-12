package com.desafio.pacto.entities.dto;

import com.desafio.pacto.entities.DateEntity;
import com.desafio.pacto.entities.enums.CandidacyStatusEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class CandidacyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private JobVacancyDTO jobVacancy;
    private UserDTO user;
    private CandidacyStatusEnum status;
    private DateEntity dateEntity;
}
