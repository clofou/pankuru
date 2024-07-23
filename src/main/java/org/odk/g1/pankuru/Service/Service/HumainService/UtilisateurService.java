package org.odk.g1.pankuru.Service.Service.HumainService;

import java.util.List;
import java.util.Optional;


import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Repository.HumainRepo.UtilisateurRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurService implements CrudService<Utilisateur, Long>{

    private final UtilisateurRepo utilisateurRepo;
    @Override
    public Utilisateur ajout(Utilisateur entity) {
        return utilisateurRepo.save(entity);
    }

    @Override
    public List<Utilisateur> liste() {
        return utilisateurRepo.findAll();
    }

    @Override
    public Optional<Utilisateur> trouverParId(Long id) {
        return utilisateurRepo.findById(id);
    }

    @Override
    public Utilisateur misAJour(Utilisateur entity) {
        Optional<Utilisateur> utilisateurExistant = utilisateurRepo.findById(entity.getId());
        if (utilisateurExistant.isPresent()) {
            Utilisateur utilisateurAModifier = utilisateurExistant.get();
            utilisateurAModifier.setNom(entity.getNom());
            utilisateurAModifier.setPrenom(entity.getPrenom());
            utilisateurAModifier.setEmail(entity.getEmail());
            utilisateurAModifier.setMotDePasse(entity.getMotDePasse());
            utilisateurAModifier.setNumeroDeTelephone(entity.getNumeroDeTelephone());
            utilisateurAModifier.setPointDeFideliter(entity.getPointDeFideliter());
            utilisateurAModifier.setDateDeNaissance(entity.getDateDeNaissance());
            utilisateurAModifier.setNumeroDePassport(entity.getNumeroDePassport());
            utilisateurAModifier.setNumeroDeVisa(entity.getNumeroDeVisa());
            return utilisateurRepo.save(utilisateurAModifier);
        } else {
            throw new IllegalArgumentException("L'utilisateur avec l'ID " + entity.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Long id) {
        utilisateurRepo.deleteById(id);
    }
    
}
