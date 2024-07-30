package org.odk.g1.pankuru.Entity.ReservationDeVol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
// import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.odk.g1.pankuru.Entity.Enum.Statut;
import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Entity.Paiement.Paiement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateReservation;
    private int nombreDepassager = 1;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private Date dateAnnulation;
    private String raisonAnnulation;

    @ManyToOne
    @JoinColumn(name = "vol_id")
    private Vol vol;

    @OneToMany(mappedBy = "reservation")
    private List<Passager> passagerList;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @JsonIgnore
    @OneToOne(mappedBy = "reservation")
    private Paiement paiement;

}
