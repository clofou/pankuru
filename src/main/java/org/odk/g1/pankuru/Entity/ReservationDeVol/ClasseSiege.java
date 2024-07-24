package org.odk.g1.pankuru.Entity.ReservationDeVol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClasseSiege {
    @Id
    private Integer id;
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
   private Set<PositionSiege>positionSiege;
}
