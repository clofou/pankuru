package org.odk.g1.pankuru.Entity.Humain;

import jakarta.persistence.Entity;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur extends Personne {
    private int pointDeFideliter = 0;
    private Date dateDeNaissance;
    private String numeroDePassport;
    private String numeroDeVisa;
}
