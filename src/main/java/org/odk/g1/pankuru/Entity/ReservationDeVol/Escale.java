package org.odk.g1.pankuru.Entity.ReservationDeVol;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.odk.g1.pankuru.Entity.Compagnie.Avion;
import org.odk.g1.pankuru.Entity.Localite.Aeroport;
import java.util.Date;

@Entity
@Table(name = "escale")
@Data
@NoArgsConstructor
public class Escale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateEtHeure;

    @ManyToOne
    @JoinColumn(name = "vol_id")
    private Vol vols;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avions;

    @ManyToOne
    @JoinColumn(name = "aeroport_id")
    private Aeroport aeroports;
}
