package org.odk.g1.pankuru.Entity.Localite;

import java.util.List;

import jakarta.persistence.*;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Aeroport")
@Data
@NoArgsConstructor
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String codeIATA;
    private double longitude;
    private double latitude;
    private double altitude;
    private int capaciteParking;
    private int nombreDePistes;
    
    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @JsonIgnore
    @ManyToMany(mappedBy = "aeroportList")
    private List<Vol> vols;
}
