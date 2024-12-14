package com.desafio.pacto.services.impl;


import com.desafio.pacto.entities.Candidacy;
import com.desafio.pacto.entities.JobVacancy;
import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.CandidacyDTO;
import com.desafio.pacto.entities.enums.CandidacyStatusEnum;
import com.desafio.pacto.repositories.CandidacyRepository;
import com.desafio.pacto.repositories.JobVacancyRepository;
import com.desafio.pacto.repositories.UserRepository;
import com.desafio.pacto.services.CandidacyService;
import com.desafio.pacto.util.parser.CandidacyParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidacyServiceImpl implements CandidacyService {

    @Autowired
    private CandidacyRepository candidacyRepository;

    @Autowired
    private JobVacancyRepository jobVacancyRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public CandidacyDTO applyToJob(CandidacyDTO candidacyDTO) {


        JobVacancy jobVacancy = jobVacancyRepository.findById(candidacyDTO.getJobVacancy().getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada"));


        User applicant = userRepository.findById(candidacyDTO.getUser().getId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));

        boolean isAlreadyApplied = candidacyRepository.existsByJobVacancyAndApplicant(jobVacancy, applicant);
        if (isAlreadyApplied) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Você já se inscreveu para esta vaga.");
        }


        Candidacy candidacy = CandidacyParser.deDTO(candidacyDTO);
        candidacy.setJobVacancy(jobVacancy);
        candidacy.setApplicant(applicant);


        Candidacy savedCandidacy = candidacyRepository.save(candidacy);

        return CandidacyParser.toDTO(savedCandidacy);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CandidacyDTO> listCandidacies() {
        List<Candidacy> candidacies = candidacyRepository.findAll();
        return candidacies.stream().map(CandidacyParser::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CandidacyDTO> listCandidaciesByJob(Long jobVacancyId) {
        List<Candidacy> candidacies = candidacyRepository.findByJobVacancyId(jobVacancyId);

        return candidacies.stream().map(CandidacyParser::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CandidacyDTO> listCandidaciesByApplicant(Long applicantId) {
        List<Candidacy> candidacies = candidacyRepository.findByApplicantId(applicantId);

        return candidacies.stream().map(CandidacyParser::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CandidacyDTO updateCandidacyStatus(Long candidacyId, String status, String feedback) {
        Candidacy candidacy = candidacyRepository.findById(candidacyId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidatura não encontrada"));

        try {
            CandidacyStatusEnum newStatus = CandidacyStatusEnum.valueOf(status.toUpperCase());
            candidacy.setStatus(newStatus);
            candidacy.setFeedback(feedback);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status invalido");
        }

        Candidacy updatedCandidacy = candidacyRepository.save(candidacy);
        return CandidacyParser.toDTO(updatedCandidacy);
    }

    @Override
    public CandidacyDTO deleteCandidacy(Long candidacyId) throws Exception {
        Optional<Candidacy> candidacy = candidacyRepository.findById(candidacyId);

        if (candidacy.isPresent()) {
            throw new Exception("Candidatura não encontrada");
        }
        candidacyRepository.deleteById(candidacyId);
        return CandidacyParser.toDTO(candidacy.get());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CandidacyDTO> listCandidaciesByAdmin(Long adminId) {
        List<JobVacancy> jobVacancies = jobVacancyRepository.findByCreatedById(adminId);

        List<Long> jobVacancyIds = jobVacancies.stream()
                .map(JobVacancy::getId)
                .collect(Collectors.toList());

        List<Candidacy> candidacies = candidacyRepository.findByJobVacancyIdIn(jobVacancyIds);

        return candidacies.stream()
                .map(CandidacyParser::toDTO)
                .collect(Collectors.toList());

    }
}


