package com.e2t.petools.common.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
public class PetObject {

    @Id
    @Column(name = "IdPet")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPet;

    @Column(name = "IsDeleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreationDate", updatable = false)
    private final Date creationDate = Calendar.getInstance().getTime();

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
