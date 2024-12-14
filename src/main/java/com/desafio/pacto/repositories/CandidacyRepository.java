package com.desafio.pacto.repositories;

import com.desafio.pacto.entities.Candidacy;
import com.desafio.pacto.entities.JobVacancy;
import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.enums.CandidacyStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidacyRepository extends JpaRepository<Candidacy,Long>{

    List<Candidacy> findByJobVacancyId(Long jobVacancyId);

    List<Candidacy> findByApplicantId(Long applicantId);

    List<Candidacy> findByStatus(CandidacyStatusEnum status);

    List<Candidacy> findByJobVacancyIdAndApplicantId(Long jobVacancyId, Long applicantId);

    List<Candidacy> findByJobVacancyIdAndStatus(Long jobVacancyId, CandidacyStatusEnum status);

    boolean existsByJobVacancyAndApplicant(JobVacancy jobVacancy, User applicant);

    List<Candidacy> findByJobVacancyIdIn(List<Long> jobVacancyIds);

}
