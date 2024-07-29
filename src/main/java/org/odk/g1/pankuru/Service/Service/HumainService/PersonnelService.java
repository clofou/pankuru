package org.odk.g1.pankuru.Service.Service.HumainService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Entity.Humain.Personnel;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonnelRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class PersonnelService implements CrudService<Personnel, Long>{

    private final PersonnelRepo personnelRepo;
    @Override
    public Personnel ajout(Personnel entity) {
        return personnelRepo.save(entity);
    }

    @Override
    public List<Personnel> liste() {
        return personnelRepo.findAll();
    }

    @Override
    public Optional<Personnel> trouverParId(Long id) {
        return personnelRepo.findById(id);
    }

    @Override
    public Personnel misAJour(Personnel entity) {
        Optional<Personnel> personnelExistant = personnelRepo.findById(entity.getId());
        if (personnelExistant.isPresent()) {
            Personnel personnelAModifier = personnelExistant.get();
            personnelAModifier.setNom(entity.getNom());
            personnelAModifier.setPrenom(entity.getPrenom());
            personnelAModifier.setEmail(entity.getEmail());
            personnelAModifier.setPassword(entity.getPassword());
            personnelAModifier.setNumeroDeTelephone(entity.getNumeroDeTelephone());
            personnelAModifier.setDateEmbauche(entity.getDateEmbauche());
            personnelAModifier.setPoste(entity.getPoste());
            personnelAModifier.setEnService(entity.isEnService());
            return personnelRepo.save(personnelAModifier);
        } else {
            throw new IllegalArgumentException("Le personnel avec l'ID " + entity.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Long id) {
        personnelRepo.deleteById(id);
    }

}
