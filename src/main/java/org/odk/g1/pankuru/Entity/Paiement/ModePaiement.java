package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ModePaiement {
    @Id
    private String id;
    @OneToMany
    private List<Paiement> paiements;
}
