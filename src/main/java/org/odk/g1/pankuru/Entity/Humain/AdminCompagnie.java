package org.odk.g1.pankuru.Entity.Humain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;

import java.util.List;

import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminCompagnie extends Personne {
    private String pseudo;

    @ManyToOne
    @JoinColumn(name = "compagnie_id")
    private Compagnie compagnie;

    @JsonIgnore
    @OneToMany
    private List<Rapport> rapportList;


}
