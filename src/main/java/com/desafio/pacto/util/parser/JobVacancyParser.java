package com.desafio.pacto.util.parser;

import com.desafio.pacto.entities.JobVacancy;
import com.desafio.pacto.entities.dto.JobVacancyDTO;

public class JobVacancyParser {

    public static JobVacancy deDTO(JobVacancyDTO jobVacancyDTO){
        JobVacancy jobVacancy = new JobVacancy();
        jobVacancy.setId(jobVacancyDTO.getId());
        jobVacancy.setTitle(jobVacancyDTO.getTitle());
        jobVacancy.setDescription(jobVacancyDTO.getDescription());
        jobVacancy.setCreatedById(jobVacancyDTO.getCreatedById());
        jobVacancy.setRequiredSkills(SkillParser.deDTOs(jobVacancyDTO.getRequiredSkills()));

        return jobVacancy;

    }


    public static JobVacancyDTO toDTO(JobVacancy jobVacancy){
        JobVacancyDTO jobVacancyDTO = new JobVacancyDTO();
        jobVacancyDTO.setId(jobVacancy.getId());
        jobVacancyDTO.setTitle(jobVacancy.getTitle());
        jobVacancyDTO.setDescription(jobVacancy.getDescription());
        jobVacancyDTO.setCreatedById(jobVacancy.getCreatedById());
        jobVacancyDTO.setRequiredSkills(SkillParser.paraDTOS(jobVacancy.getRequiredSkills()));
        jobVacancyDTO.setDateEntity(jobVacancy.getDateEntity());

        return jobVacancyDTO;
    }
}
