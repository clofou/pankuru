package org.odk.g1.pankuru.Entity.Localite;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Pays")
@Data
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "pays", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ville> villeList;
}
