package org.odk.g1.pankuru.Entity.Humain;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdmin extends Personne{
    private String pseudo;
}
