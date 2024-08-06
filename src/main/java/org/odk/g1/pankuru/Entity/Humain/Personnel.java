package org.odk.g1.pankuru.Entity.Humain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personnel extends Personne {
    private LocalDate dateEmbauche = LocalDate.now();
    @Column(nullable = false)
    private String poste;
    private boolean enService = false;

    @ManyToOne
    @JoinColumn(name = "adminCompagnie_id")
    private AdminCompagnie adminCompagnie;


}
