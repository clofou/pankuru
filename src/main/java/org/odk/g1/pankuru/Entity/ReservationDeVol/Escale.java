package org.odk.g1.pankuru.Entity.ReservationDeVol;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.odk.g1.pankuru.Entity.Compagnie.Avion;
import org.odk.g1.pankuru.Entity.Localite.Aeroport;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "escale")
@Data
@NoArgsConstructor
public class Escale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateEtHeure;

    @ManyToMany
    @JoinTable(name = "vol_escale",
            joinColumns = @JoinColumn(name = "vol_id"),
            inverseJoinColumns = @JoinColumn(name = "escale_id"))
    private Set<Vol> vols;

    @ManyToMany
    @JoinTable(name = "avion_escale",
            joinColumns = @JoinColumn(name = "avion_id"),
            inverseJoinColumns = @JoinColumn(name = "escale_id"))
    private Set<Avion> avions;

    @ManyToMany
    @JoinTable(name = "aeroport_escale",
            joinColumns = @JoinColumn(name = "aeroport_id"),
            inverseJoinColumns = @JoinColumn(name = "escale_id"))
    private Set<Aeroport> aeroports;
}
