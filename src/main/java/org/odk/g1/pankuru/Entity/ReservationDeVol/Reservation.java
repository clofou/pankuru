package org.odk.g1.pankuru.Entity.ReservationDeVol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.odk.g1.pankuru.Entity.Enum.Statut;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    private Long id;
    private LocalDate dateReservation;
    private int nombreDepassager;
    private Statut statut;
    private LocalDate dateAnnulation;
    private String raisonAnnulation;
    @ManyToOne()
    private Vol vol;

}
