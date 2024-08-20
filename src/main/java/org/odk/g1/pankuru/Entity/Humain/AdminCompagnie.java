package org.odk.g1.pankuru.Entity.Humain;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminCompagnie extends Personne {

    private String pseudo;
    @ManyToOne
    private Compagnie compagnie;
    @ManyToOne
    private SuperAdmin superAdmin;


}
