package com.desafio.pacto.util.parser;

import com.desafio.pacto.entities.Candidacy;
import com.desafio.pacto.entities.dto.CandidacyDTO;

public class CandidacyParser {

    public static Candidacy deDTO(CandidacyDTO candidacyDTO) {
        Candidacy candidacy = new Candidacy();
        candidacy.setId(candidacyDTO.getId());
        return candidacy;
    }

    public static CandidacyDTO toDTO(Candidacy candidacy) {
        CandidacyDTO candidacyDTO = new CandidacyDTO();
        candidacyDTO.setId(candidacy.getId());
        candidacyDTO.setDateEntity(candidacy.getDateEntity());
        return candidacyDTO;
    }
}
