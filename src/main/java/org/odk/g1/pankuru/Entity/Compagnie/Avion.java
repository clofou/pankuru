package org.odk.g1.pankuru.Entity.Compagnie;

import java.util.List;

import org.odk.g1.pankuru.Entity.Enum.StatutAvion;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
}
