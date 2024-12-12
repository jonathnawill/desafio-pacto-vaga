package com.desafio.pacto.services;

import com.desafio.pacto.entities.Skill;
import com.desafio.pacto.entities.dto.SkillDTO;

import java.util.List;

public interface SkillService {

    SkillDTO createSkill (SkillDTO skill);

    List<SkillDTO> list();
}
