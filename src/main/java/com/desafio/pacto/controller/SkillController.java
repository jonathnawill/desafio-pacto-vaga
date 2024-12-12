package com.desafio.pacto.controller;

import com.desafio.pacto.entities.Skill;
import com.desafio.pacto.entities.dto.JobVacancyDTO;
import com.desafio.pacto.entities.dto.SkillDTO;
import com.desafio.pacto.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;


    @PostMapping("/create")
    public ResponseEntity<SkillDTO> createSkill (@RequestBody SkillDTO skillDTO) {
        SkillDTO createSkill = skillService.createSkill(skillDTO);
        return new ResponseEntity<>(createSkill, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<SkillDTO>> listSkill() {
        List<SkillDTO> skills = skillService.list();
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

}
