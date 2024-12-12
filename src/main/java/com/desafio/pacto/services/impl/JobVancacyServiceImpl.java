package com.desafio.pacto.services.impl;

import com.desafio.pacto.entities.JobVacancy;
import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.JobVacancyDTO;
import com.desafio.pacto.entities.enums.UserRoleEnum;
import com.desafio.pacto.repositories.JobVacancyRepository;
import com.desafio.pacto.repositories.UserRepository;
import com.desafio.pacto.services.JobVacancyService;
import com.desafio.pacto.util.parser.JobVacancyParser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobVancacyServiceImpl implements JobVacancyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobVacancyRepository jobVacancyRepository;

    @Transactional
    @Override
    public JobVacancyDTO createJobVacancy(JobVacancyDTO jobVacancyDTO) {

        User user = userRepository.findById(jobVacancyDTO.getCreatedById()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );

        if (!user.getUserRole().equals(UserRoleEnum.ADMIN_USER)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Somente administradores podem criar vagas de emprego");
        }

        JobVacancy jobVacancy = JobVacancyParser.deDTO(jobVacancyDTO);

        JobVacancy savedJobVacancy = jobVacancyRepository.save(jobVacancy);

        return JobVacancyParser.toDTO(savedJobVacancy);
    }


    @Override
    @Transactional
    public List<JobVacancyDTO> listJobVacancies() {
    List<JobVacancy> jobs = jobVacancyRepository.findAll();

        return jobs.stream().map(JobVacancyParser::toDTO).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void deleteJobVacancy(Long jobId) {

        JobVacancy jobVacancy = jobVacancyRepository.findById(jobId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada!")
        );

        jobVacancyRepository.delete(jobVacancy);
    }

}
