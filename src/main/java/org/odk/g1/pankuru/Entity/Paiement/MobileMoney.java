package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MobileMoney extends ModePaiement{
    private double numeroDeTelephone;
}
