package org.odk.g1.pankuru.Entity.ReservationDeVol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.odk.g1.pankuru.Entity.Enum.StatutVol;
// import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vol {
    @Id
    private Long id;
    private  String numeroDeVol;
    private String aeroportDepart;
    private String aeroportArriverString;
    private LocalDate dateEtHeureArrivee;
    private LocalDate dateEtHeureDepart;
    private StatutVol satut;
    @JsonIgnore
    @OneToMany(mappedBy = "vol",cascade = CascadeType.ALL)
    private Set<Reservation> reservation;
}
