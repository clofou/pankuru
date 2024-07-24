package org.odk.g1.pankuru.Entity.ReservationDeVol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PositionSiege {
    @Id
    private Integer id;
    private String nom;

    @ManyToOne
    private ClasseSiege classe;
    @JsonIgnore
    @OneToMany(mappedBy = "positionSiege",cascade = CascadeType.ALL)
    private Set<Siege>siege;
}
