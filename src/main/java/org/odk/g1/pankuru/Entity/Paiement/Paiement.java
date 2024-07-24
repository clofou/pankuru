package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.*;
import lombok.Data;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.springframework.boot.Banner;

import java.util.Date;

@Entity
@Data
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    double montant;
    Date datePaiement;

    @OneToOne
    private Reservation reservation;
    @ManyToOne
    private ModePaiement modePaiement;
}
