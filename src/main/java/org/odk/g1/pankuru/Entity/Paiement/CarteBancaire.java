package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.Entity;
// import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CarteBancaire extends ModePaiement{
    private String numeroDeCarte;
    private String nomTitulaire;
    private String dateExpiration;
    private String typeCarte;
    private String adresseFacturation;
}
