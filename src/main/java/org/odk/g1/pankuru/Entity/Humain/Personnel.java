package org.odk.g1.pankuru.Entity.Humain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;

import java.util.Date;

import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personnel extends Personne {
    private Date dateEmbauche;
    private String poste;
    private boolean enService;

    @ManyToOne
    @JoinColumn(name = "compagnie_id")
    private Compagnie compagnie;


}
