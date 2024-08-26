package org.odk.g1.pankuru.Entity.Humain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur extends Personne {
    private int pointDeFideliter = 0;
    private String numeroDePassport;
    private String numeroDeVisa;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private List<Reservation> reservationList;
}
