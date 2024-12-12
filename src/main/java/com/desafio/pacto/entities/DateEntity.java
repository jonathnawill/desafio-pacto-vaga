package com.desafio.pacto.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
public class DateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "REGISTER", updatable = false, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime register;

    @Column(name = "REFRESH", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime refresh;

    @Column(name = "ACTIVE", nullable = false, length = 1)
    private boolean active;


    public DateEntity(boolean active) {

        super();
        this.active = active;
    }

    public DateEntity(LocalDateTime register, LocalDateTime refresh, boolean active) {
        this.register = register;
        this.refresh = refresh;
        this.active = active;
    }
}
