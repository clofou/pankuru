package org.odk.g1.pankuru.Entity.ReservationDeVol;

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
public class TypeBagage {
    @Id
    private Integer id;
    private String nom;
    @OneToMany(mappedBy = "typeBagage")
    private Set<Bagage>bagage;

}
