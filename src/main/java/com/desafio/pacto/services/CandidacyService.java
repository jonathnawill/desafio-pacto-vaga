package com.desafio.pacto.services;

import com.desafio.pacto.entities.dto.CandidacyDTO;

import java.util.List;

public interface CandidacyService {

    CandidacyDTO applyToJob(CandidacyDTO candidacyDTO);

    List<CandidacyDTO> listCandidacies();

    List<CandidacyDTO> listCandidaciesByJob(Long jobVacancyId);

    List<CandidacyDTO> listCandidaciesByApplicant(Long applicantId);

    CandidacyDTO updateCandidacyStatus(Long candidacyId, String status, String feedback);

    CandidacyDTO deleteCandidacy(Long candidacyId) throws Exception;

    List<CandidacyDTO> listCandidaciesByAdmin(Long adminId);


}
