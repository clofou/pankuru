package org.odk.g1.pankuru.Service.Service.HumainService;

import java.util.List;
import java.util.Optional;

import org.odk.g1.pankuru.Entity.Humain.AdminCompagnie;
import org.odk.g1.pankuru.Repository.HumainRepo.AdminCompagnieRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminCompagnieService implements CrudService<AdminCompagnie, Long>{

    private final AdminCompagnieRepo adminCompagnieRepo;

    @Override
    public AdminCompagnie ajout(AdminCompagnie entity) {
        return adminCompagnieRepo.save(entity);
    }

    @Override
    public List<AdminCompagnie> liste() {
        return adminCompagnieRepo.findAll();
    }

    @Override
    public Optional<AdminCompagnie> trouverParId(Long id) {
        return adminCompagnieRepo.findById(id);
    }

    @Override
    public AdminCompagnie misAJour(AdminCompagnie entity) {
        Optional<AdminCompagnie> adminCompagnieExistant = adminCompagnieRepo.findById(entity.getId());
        if (adminCompagnieExistant.isPresent()) {
            AdminCompagnie adminCompagnieAModifier = adminCompagnieExistant.get();
            adminCompagnieAModifier.setNom(entity.getNom());
            adminCompagnieAModifier.setPrenom(entity.getPrenom());
            adminCompagnieAModifier.setEmail(entity.getEmail());
            adminCompagnieAModifier.setMotDePasse(entity.getMotDePasse());
            adminCompagnieAModifier.setNumeroDeTelephone(entity.getNumeroDeTelephone());
            adminCompagnieAModifier.setPseudo(entity.getPseudo());
            return adminCompagnieRepo.save(adminCompagnieAModifier);
        } else {
            throw new IllegalArgumentException("L'admin de la compagnie avec l'ID " + entity.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Long id) {
        adminCompagnieRepo.deleteById(id);
    }
    
}
