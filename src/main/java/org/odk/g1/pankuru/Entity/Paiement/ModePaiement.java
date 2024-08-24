package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class ModePaiement {
    @Id
    private String id;

}
