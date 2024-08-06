package org.odk.g1.pankuru.Entity.Compagnie;

import java.util.List;

import jakarta.persistence.*;
import org.odk.g1.pankuru.Entity.Enum.StatutAvion;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Escale;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Avion")
@Data
@NoArgsConstructor
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricule;
    private int capaciteTotale;
    private String nom;
    private StatutAvion statut;

    @ManyToOne
    @JoinColumn(name = "compagnie_id")
    private Compagnie compagnie;

    @ManyToMany
    @JoinTable(name = "vol_id")
    private List<Vol> vol;

    @OneToMany(mappedBy = "Avion")
    private List<Escale> escales;
}
