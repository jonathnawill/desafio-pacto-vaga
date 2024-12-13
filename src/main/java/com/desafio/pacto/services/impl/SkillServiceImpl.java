package com.desafio.pacto.services.impl;

import com.desafio.pacto.entities.Skill;
import com.desafio.pacto.entities.dto.SkillDTO;
import com.desafio.pacto.repositories.SkillRepository;
import com.desafio.pacto.services.SkillService;
import com.desafio.pacto.util.parser.JobVacancyParser;
import com.desafio.pacto.util.parser.SkillParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {


    @Autowired
    private SkillRepository skillRepository;


    @Override
    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill exist =  skillRepository.findSkillBySkillName(skillDTO.getSkillName());

        if (exist != null) {
            throw  new IllegalArgumentException("Skill já existente");
        }

        Skill skill = SkillParser.deDTO(skillDTO);

        skillRepository.save(skill);

        return SkillParser.paraDTO(skill);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SkillDTO> list(){
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(SkillParser::paraDTO).collect(Collectors.toList());
    }
}