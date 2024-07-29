package org.odk.g1.pankuru.Entity.ReservationDeVol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import org.springframework.security.access.method.P;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Siege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String numero;
    private Boolean disponibilite = true;

    @ManyToOne
    @JoinColumn(nullable = false, name = "positionSiege_id")
    private PositionSiege positionSiege;
    
    @JsonIgnore
    @OneToMany(mappedBy = "siege",cascade = CascadeType.ALL)
    private List<Passager> passagerList;

}
