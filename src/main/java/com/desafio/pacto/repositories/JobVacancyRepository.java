package com.desafio.pacto.repositories;

import com.desafio.pacto.entities.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobVacancyRepository  extends JpaRepository<JobVacancy, Long> {


    List<JobVacancy> findByCreatedById(Long adminId);

}
