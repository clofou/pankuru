package org.odk.g1.pankuru.Entity.Compagnie;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Compagnie")
@Data
@NoArgsConstructor
public class Compagnie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricule;
    private String nom;
    private String logo;
    private int codeIATA;
    private String codeICAO;
    private String numeroTelephone;
    private String email;
    private String siteWeb;
    private String numeroLicence;

    @OneToMany(mappedBy = "compagnie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrat> contrats;
}
