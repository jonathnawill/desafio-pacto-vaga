package com.desafio.pacto.controller;

import com.desafio.pacto.entities.dto.CandidacyDTO;
import com.desafio.pacto.services.CandidacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidacy")
public class CandidacyController {

    @Autowired
    private CandidacyService candidacyService;


    @PostMapping("/apply")
    public ResponseEntity<CandidacyDTO> applyForJob(@RequestBody CandidacyDTO candidacyDTO) {
        CandidacyDTO createdCandidacy = candidacyService.applyToJob(candidacyDTO);
        return new ResponseEntity<>(createdCandidacy, HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public ResponseEntity<List<CandidacyDTO>> listCandidacies() {
        List<CandidacyDTO> candidacies = candidacyService.listCandidacies();
        return new ResponseEntity<>(candidacies, HttpStatus.OK);
    }


    @GetMapping("/job/{jobVacancyId}")
    public ResponseEntity<List<CandidacyDTO>> listCandidaciesByJobVacancy(@PathVariable Long jobVacancyId) {
        List<CandidacyDTO> candidacies = candidacyService.listCandidaciesByJob(jobVacancyId);
        return new ResponseEntity<>(candidacies, HttpStatus.OK);
    }


    @GetMapping("/user/{applicantId}")
    public ResponseEntity<List<CandidacyDTO>> listCandidaciesByApplicant(@PathVariable Long applicantId) {
        List<CandidacyDTO> candidacies = candidacyService.listCandidaciesByApplicant(applicantId);
        return new ResponseEntity<>(candidacies, HttpStatus.OK);
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<CandidacyDTO> updateCandidacyStatus(@PathVariable Long id, @RequestParam String status) {
        CandidacyDTO updatedCandidacy = candidacyService.updateCandidacyStatus(id, status);
        return new ResponseEntity<>(updatedCandidacy, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidacy(@PathVariable Long id) throws Exception {
        candidacyService.deleteCandidacy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
