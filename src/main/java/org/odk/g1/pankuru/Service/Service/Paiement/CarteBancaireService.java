package org.odk.g1.pankuru.Service.Service.Paiement;

import org.odk.g1.pankuru.Entity.Paiement.CarteBancaire;

import org.odk.g1.pankuru.Repository.Paiement.CarteBancaireRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarteBancaireService implements CrudService<CarteBancaire, Long> {
    @Autowired
    CarteBancaireRepository carteBancaireRepository;

    @Override
    public CarteBancaire ajout(CarteBancaire carteBancaire) {
        return carteBancaireRepository.save(carteBancaire);
    }

    @Override
    public List<CarteBancaire> liste() {
        return carteBancaireRepository.findAll();
    }

    @Override
    public Optional<CarteBancaire> trouverParId(Long carteBancaireId) {
        return carteBancaireRepository.findById(carteBancaireId);
    }

    @Override
    public CarteBancaire misAJour(CarteBancaire newInfoCarteBancaire, Long Id) {
        CarteBancaire carteBancaireBD = carteBancaireRepository.getReferenceById(Id);

        if (newInfoCarteBancaire.getNumeroDeCarte() != null &&
                !newInfoCarteBancaire.getNumeroDeCarte().isEmpty() &&
                !Objects.equals(newInfoCarteBancaire.getNumeroDeCarte(), carteBancaireBD.getNumeroDeCarte())) {
            carteBancaireBD.setNumeroDeCarte(newInfoCarteBancaire.getNumeroDeCarte());
        }

        if (newInfoCarteBancaire.getNomTitulaire() != null &&
                !newInfoCarteBancaire.getNomTitulaire().isEmpty() &&
                !Objects.equals(newInfoCarteBancaire.getNomTitulaire(), carteBancaireBD.getNomTitulaire())) {
            carteBancaireBD.setNomTitulaire(newInfoCarteBancaire.getNomTitulaire());
        }

        if (newInfoCarteBancaire.getDateExpiration() != null &&
                !newInfoCarteBancaire.getDateExpiration().isEmpty() &&
                !Objects.equals(newInfoCarteBancaire.getDateExpiration(), carteBancaireBD.getDateExpiration())) {
            carteBancaireBD.setDateExpiration(newInfoCarteBancaire.getDateExpiration());
        }

        if (newInfoCarteBancaire.getTypeCarte() != null &&
                !newInfoCarteBancaire.getTypeCarte().isEmpty() &&
                !Objects.equals(newInfoCarteBancaire.getTypeCarte(), carteBancaireBD.getTypeCarte())) {
            carteBancaireBD.setTypeCarte(newInfoCarteBancaire.getTypeCarte());
        }

        if (newInfoCarteBancaire.getAdresseFacturation() != null &&
                !newInfoCarteBancaire.getAdresseFacturation().isEmpty() &&
                !Objects.equals(newInfoCarteBancaire.getAdresseFacturation(), carteBancaireBD.getAdresseFacturation())) {
            carteBancaireBD.setAdresseFacturation(newInfoCarteBancaire.getAdresseFacturation());
        }

        return carteBancaireBD;
    }

    @Override
    public void supprimer(Long carteBancaireId) {
        CarteBancaire carteBancaire =carteBancaireRepository
                .getReferenceById(carteBancaireId);
        carteBancaireRepository.delete(carteBancaire);
    }
}
