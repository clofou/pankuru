package org.odk.g1.pankuru.Entity.ReservationDeVol;

import jakarta.persistence.*;
// import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.odk.g1.pankuru.Entity.Enum.Statut;
import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Entity.Paiement.Paiement;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateReservation;
    private int nombreDepassager;
    private Statut statut;
    private LocalDate dateAnnulation;
    private String raisonAnnulation;

    @ManyToOne
    private Vol vol;

    @OneToMany()
    private Set<Passager> passager;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToOne
    private Paiement paiement;

}
