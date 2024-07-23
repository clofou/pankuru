package org.odk.g1.pankuru.Service.Service.HumainService;

import java.util.List;
import java.util.Optional;

import org.odk.g1.pankuru.Entity.Humain.SuperAdmin;
import org.odk.g1.pankuru.Repository.HumainRepo.SuperAdminRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SuperAdminService implements CrudService<SuperAdmin, Long>{

    private final SuperAdminRepo superAdminRepo;
    @Override
    public SuperAdmin ajout(SuperAdmin entity) {
        return superAdminRepo.save(entity);
    }

    @Override
    public List<SuperAdmin> liste() {
        return superAdminRepo.findAll();
    }

    @Override
    public Optional<SuperAdmin> trouverParId(Long id) {
        return superAdminRepo.findById(id);
    }

    @Override
    public SuperAdmin misAJour(SuperAdmin superAdmin) {
        Optional<SuperAdmin> superAdminExistant = superAdminRepo.findById(superAdmin.getId());
        if (superAdminExistant.isPresent()) {
            SuperAdmin superAdminAModifier = superAdminExistant.get();
            superAdminAModifier.setNom(superAdmin.getNom());
            superAdminAModifier.setPrenom(superAdmin.getPrenom());
            superAdminAModifier.setEmail(superAdmin.getEmail());
            superAdminAModifier.setMotDePasse(superAdmin.getMotDePasse());
            superAdminAModifier.setNumeroDeTelephone(superAdmin.getNumeroDeTelephone());
            superAdminAModifier.setPseudo(superAdmin.getPseudo());
            return superAdminRepo.save(superAdminAModifier);
        } else {
            throw new IllegalArgumentException("Le super admin avec l'ID " + superAdmin.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Long id) {
        superAdminRepo.deleteById(id);
    }
    
}
