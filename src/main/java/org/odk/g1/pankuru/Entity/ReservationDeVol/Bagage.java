package org.odk.g1.pankuru.Entity.ReservationDeVol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bagage {
    @Id
    private Long id;
    private Float poids;
    private String dimension;
    @ManyToOne
    private Passager passager;
    @ManyToOne
    private TypeBagage typeBagage;
}
