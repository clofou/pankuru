package org.odk.g1.pankuru.Entity.Paiement;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CarteBancaire extends ModePaiement{
    private String numeroDeCarte;
    private String nomTitulaire;
    private String dateExpiration;
    private String typeCarte;
    private String adresseFacturation;
}
