package org.odk.g1.pankuru.Entity.Humain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdmin extends Personne{
    private String pseudo;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "compagnie_id")
    private List<Compagnie> compagnieList;
}
