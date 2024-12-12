package com.desafio.pacto.repositories;

import com.desafio.pacto.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    Skill findSkillBySkillName(String skillName);
}
