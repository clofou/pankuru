package org.odk.g1.pankuru.Entity.Localite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
}
