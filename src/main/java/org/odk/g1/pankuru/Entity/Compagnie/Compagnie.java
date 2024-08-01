package org.odk.g1.pankuru.Entity.Compagnie;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.AdminCompagnie;
import org.odk.g1.pankuru.Entity.Humain.Personnel;
import org.odk.g1.pankuru.Entity.Humain.SuperAdmin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "superAdmin_id")
    private SuperAdmin superAdmin;

    
    @OneToMany(mappedBy = "compagnie")
    private List<Contrat> contratList;

    
    @OneToMany(mappedBy = "compagnie")
    private List<Personnel> personnelList;

    
    @OneToMany(mappedBy = "compagnie")
    private List<Avion> avionList;

    
    @OneToMany(mappedBy = "compagnie")
    private List<AdminCompagnie> adminCompagnieList;
}
