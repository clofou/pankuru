package org.odk.g1.pankuru.Entity.Humain;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;

import java.util.Date;
import java.util.List;
// import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur extends Personne {
    private int pointDeFideliter = 0;
    private Date dateDeNaissance;
    private String numeroDePassport;
    private String numeroDeVisa;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur")
    private List<Reservation> reservationList;
}
