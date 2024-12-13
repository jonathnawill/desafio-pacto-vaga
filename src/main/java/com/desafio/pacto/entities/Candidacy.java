package com.desafio.pacto.entities;

import com.desafio.pacto.entities.enums.CandidacyStatusEnum;
import com.desafio.pacto.entities.enums.converter.CandidacyStatusEnumConverter;
import com.desafio.pacto.entities.listener.EntityCreateUpdateListener;
import javax.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "CANDIDACY")
@EntityListeners(EntityCreateUpdateListener.class)
@Data
public class Candidacy implements Serializable, DateInterface {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "candidacy_id_seq_gen", sequenceName = "candidacy_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidacy_id_seq_gen")
    @Column(name = "id_candidacy", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_vacancy_id", nullable = false)
    private JobVacancy jobVacancy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "applicant_id", nullable = false)
    private User applicant;

    @Convert(converter = CandidacyStatusEnumConverter.class)
    @Column(name = "ID_CANDIDACY_STATUS")
    private CandidacyStatusEnum status;

    @Embedded
    private DateEntity dateEntity;

}
