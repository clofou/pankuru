package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ModePaiement {
    @Id
    private String id;
    @OneToMany
    private List<Paiement> paiements;
}
