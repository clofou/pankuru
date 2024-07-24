package org.odk.g1.pankuru.Service.Interface;

import org.odk.g1.pankuru.Entity.Paiement.CarteBancaire;
import org.odk.g1.pankuru.Entity.Paiement.MobileMoney;
import org.odk.g1.pankuru.Entity.Paiement.Paiement;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    T ajout(T entity);
    List<T> liste();
    Optional<T> trouverParId(ID id);
    T misAJour(T entity);

    // T misAJour(T entity, Long Id);

    // CarteBancaire misAJour(CarteBancaire newInfoCarteBancaire, String Id);

    MobileMoney misAJour(MobileMoney newInfoMobileMoney, String mobileMoneyId);

    void supprimer(ID id);
}