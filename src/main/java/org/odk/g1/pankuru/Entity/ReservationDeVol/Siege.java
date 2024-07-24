package org.odk.g1.pankuru.Entity.ReservationDeVol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import org.springframework.security.access.method.P;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Siege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Boolean disponibilite;
    @ManyToOne
    private PositionSiege positionSiege;
    
    @JsonIgnore
    @OneToMany(mappedBy = "siege",cascade = CascadeType.ALL)
    private Set<Passager>passager;

}
