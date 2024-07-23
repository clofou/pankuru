package org.odk.g1.pankuru.Entity.Humain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rue;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private String etat;
    @Column(nullable = false)
    private String codePostal;
    @Column(nullable = false)
    private String pays;

    @JsonIgnore
    @OneToOne(mappedBy = "adresse")
    private Personne personne;

}
