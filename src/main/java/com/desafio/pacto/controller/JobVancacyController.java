package com.desafio.pacto.controller;


import com.desafio.pacto.entities.dto.JobVacancyDTO;
import com.desafio.pacto.services.JobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobVancacyController {

    @Autowired
    private JobVacancyService jobVacancyService;

    @PostMapping("/create")
    public ResponseEntity<JobVacancyDTO> createJobVacancy(@RequestBody JobVacancyDTO jobVacancyDTO) {
        JobVacancyDTO createdJobVacancy = jobVacancyService.createJobVacancy(jobVacancyDTO);
        return new ResponseEntity<>(createdJobVacancy, HttpStatus.CREATED);
    }

    @GetMapping("/admin/list/{adminId}")
    public ResponseEntity<List<JobVacancyDTO>> getAllJobVacancy(@PathVariable Long adminId) {
        List<JobVacancyDTO> jobVacancyDTO = jobVacancyService.listJobVancaciesByAdmin(adminId);
        return new ResponseEntity<>(jobVacancyDTO, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<JobVacancyDTO>> listJobVacancies() {
        List<JobVacancyDTO> jobVacancies = jobVacancyService.listJobVacancies();
        return new ResponseEntity<>(jobVacancies, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJobVacancy(@PathVariable Long id) {
        jobVacancyService.deleteJobVacancy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
