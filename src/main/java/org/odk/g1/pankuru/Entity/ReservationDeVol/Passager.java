package org.odk.g1.pankuru.Entity.ReservationDeVol;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String numeroDePassPort;
    private String numeroDeVisa;
    @ManyToOne
    private Siege siege;

    @ManyToOne
    private Reservation reservation;

    @OneToMany(mappedBy = "passager")
    private Set<Bagage> bagage;
}
