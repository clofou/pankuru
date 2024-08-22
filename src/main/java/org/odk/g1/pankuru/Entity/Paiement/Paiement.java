package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.*;
import lombok.Data;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import java.time.LocalDate;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private double montant;
    private LocalDate datePaiement = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

}
