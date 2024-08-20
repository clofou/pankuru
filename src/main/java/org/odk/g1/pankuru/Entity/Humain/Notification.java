package org.odk.g1.pankuru.Entity.Humain;

import jakarta.persistence.*;
import lombok.Data;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String objet;
    private LocalDate date;
    private LocalTime heure;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Reservation reservation;

    @ManyToOne
    private Vol vol;

}
