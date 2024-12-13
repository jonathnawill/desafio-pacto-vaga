package com.desafio.pacto.util.parser;

import com.desafio.pacto.entities.Candidacy;
import com.desafio.pacto.entities.dto.CandidacyDTO;
import com.desafio.pacto.entities.enums.CandidacyStatusEnum;

public class CandidacyParser {

    public static Candidacy deDTO(CandidacyDTO candidacyDTO) {
        Candidacy candidacy = new Candidacy();
        candidacy.setStatus(CandidacyStatusEnum.PENDING);
        return candidacy;
    }

    public static CandidacyDTO toDTO(Candidacy candidacy) {
        CandidacyDTO candidacyDTO = new CandidacyDTO();
        candidacyDTO.setId(candidacy.getId());
        candidacyDTO.setJobVacancy(JobVacancyParser.toDTO(candidacy.getJobVacancy()));
        candidacyDTO.setUser(UserParser.paraDTO(candidacy.getApplicant()));
        candidacyDTO.setStatus(candidacy.getStatus().getDescription());
        candidacyDTO.setDateEntity(candidacy.getDateEntity());
        return candidacyDTO;
    }
}
