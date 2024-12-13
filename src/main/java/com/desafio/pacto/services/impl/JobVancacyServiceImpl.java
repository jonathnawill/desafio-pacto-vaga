package com.desafio.pacto.services.impl;

import com.desafio.pacto.entities.JobVacancy;
import com.desafio.pacto.entities.Skill;
import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.JobVacancyDTO;
import com.desafio.pacto.entities.dto.SkillDTO;
import com.desafio.pacto.entities.enums.UserRoleEnum;
import com.desafio.pacto.repositories.JobVacancyRepository;
import com.desafio.pacto.repositories.SkillRepository;
import com.desafio.pacto.repositories.UserRepository;
import com.desafio.pacto.services.JobVacancyService;
import com.desafio.pacto.util.parser.JobVacancyParser;
import com.desafio.pacto.util.parser.SkillParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobVancacyServiceImpl implements JobVacancyService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobVacancyRepository jobVacancyRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    @Override
    public JobVacancyDTO createJobVacancy(JobVacancyDTO jobVacancyDTO) {

        User user = userRepository.findById(jobVacancyDTO.getCreatedById()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado")
        );

        if (!user.getUserRole().equals(UserRoleEnum.ADMIN_USER)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Somente administradores podem criar vagas de emprego");
        }

        JobVacancy jobVacancy = JobVacancyParser.deDTO(jobVacancyDTO);

        List<Skill> skills = new ArrayList<>();
        for (SkillDTO skillDTO : jobVacancyDTO.getRequiredSkills()) {
            Skill skill;
            if (skillDTO.getId() != null) {
                skill = skillRepository.findById(skillDTO.getId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill não encontrada"));
            } else {

                skill = skillRepository.save(SkillParser.deDTO(skillDTO));
            }
            skills.add(skill);
        }

        jobVacancy.setRequiredSkills(skills);
        JobVacancy savedJobVacancy = jobVacancyRepository.save(jobVacancy);

        return JobVacancyParser.toDTO(savedJobVacancy);
    }


    @Override
    @Transactional(readOnly = true)
    public List<JobVacancyDTO> listJobVacancies() {
    List<JobVacancy> jobs = jobVacancyRepository.findAll();

        return jobs.stream().map(JobVacancyParser::toDTO).collect(Collectors.toList());

    }

    @Override
    @Transactional(readOnly = true)
    public void deleteJobVacancy(Long jobId) {

        JobVacancy jobVacancy = jobVacancyRepository.findById(jobId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaga não encontrada!")
        );

        jobVacancyRepository.delete(jobVacancy);
    }

}
