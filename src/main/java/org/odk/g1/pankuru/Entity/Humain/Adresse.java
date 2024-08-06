package org.odk.g1.pankuru.Entity.Humain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rue;
    private String ville;
    private String etat;
    private String codePostal;
    private String pays;
    private String champComplet;

    @JsonIgnore
    @OneToMany(mappedBy = "adresse")
    private List<Personne> personneList;

}
