package org.odk.g1.pankuru.Entity.ReservationDeVol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passager {
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String numeroDePassPort;
    private String numeroDeVisa;
    @ManyToOne
    private Siege siege;
    @OneToMany(mappedBy = "passager")
    private Set<Bagage> bagage;
}
