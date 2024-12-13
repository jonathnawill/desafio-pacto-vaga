package com.desafio.pacto.util.parser;

import com.desafio.pacto.entities.Skill;
import com.desafio.pacto.entities.User;
import com.desafio.pacto.entities.dto.RegisterUserDTO;
import com.desafio.pacto.entities.dto.SkillDTO;
import com.desafio.pacto.entities.dto.UserDTO;
import com.desafio.pacto.entities.enums.UserRoleEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkillParser {

        public static Skill deDTO(SkillDTO skillDTO) {
            Skill skill = new Skill();
            skill.setSkillName(skillDTO.getSkillName());
            skill.setExperienceYears(skillDTO.getExperienceYears());
            return skill;
        }

        public static SkillDTO paraDTO(Skill skill) {
            SkillDTO skillDTO = new SkillDTO();
            skillDTO.setId(skill.getId());
            skillDTO.setSkillName(skill.getSkillName());
            skillDTO.setExperienceYears(skill.getExperienceYears());
            skillDTO.setDateEntity(skill.getDateEntity());
            return skillDTO;
        }


    public static List<SkillDTO> paraDTOS(List<Skill> skill){
            List<SkillDTO> skillDTOS = new ArrayList<>();

        skillDTOS = skill.stream().map(SkillParser::paraDTO).collect(Collectors.toList());

        return skillDTOS;
    }

        public static List<Skill> deDTOs(List<SkillDTO> skillsDTO){
            List<Skill> skills = new ArrayList<Skill>();
            skills = skillsDTO.stream().map(SkillParser::deDTO).collect(Collectors.toList());
            return skills;
    }
}

