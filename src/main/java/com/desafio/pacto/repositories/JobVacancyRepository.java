package com.desafio.pacto.repositories;

import com.desafio.pacto.entities.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobVacancyRepository  extends JpaRepository<JobVacancy, Long> {


}
