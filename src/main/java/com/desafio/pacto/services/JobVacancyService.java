package com.desafio.pacto.services;

import com.desafio.pacto.entities.JobVacancy;
import com.desafio.pacto.entities.dto.JobVacancyDTO;

import java.util.List;

public interface JobVacancyService {

    JobVacancyDTO createJobVacancy(JobVacancyDTO jobVacancy);

    List<JobVacancyDTO> listJobVacancies();

    void deleteJobVacancy(Long jobId);
}
