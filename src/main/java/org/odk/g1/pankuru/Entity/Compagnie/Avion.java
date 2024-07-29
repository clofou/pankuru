package org.odk.g1.pankuru.Entity.Compagnie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.odk.g1.pankuru.Entity.Enum.StatutAvion;
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
    @Enumerated(EnumType.STRING)
    private StatutAvion statut;

    @ManyToOne
    @JoinColumn(name = "compagnie_id")
    @JsonIgnore
    private Compagnie compagnie;

    @ManyToMany
    @JsonIgnore
    private List<Vol> vol;
}
