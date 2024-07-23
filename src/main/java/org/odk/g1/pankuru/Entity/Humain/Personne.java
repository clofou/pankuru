package org.odk.g1.pankuru.Entity.Humain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Email
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String motDePasse;
    private String numeroDeTelephone;


    @OneToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    // @ManyToOne
    // @JoinColumn(name = "role_id")
    // private Role role;

    @JsonIgnore
    @OneToMany
    private List<Audit> auditList;


}
