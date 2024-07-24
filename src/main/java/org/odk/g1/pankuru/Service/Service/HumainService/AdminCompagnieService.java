package org.odk.g1.pankuru.Service.Service.HumainService;

import java.util.List;
import java.util.Optional;

import org.odk.g1.pankuru.Entity.Humain.AdminCompagnie;
import org.odk.g1.pankuru.Repository.HumainRepo.AdminCompagnieRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class AdminCompagnieService implements CrudService<AdminCompagnie, Long>{

    private final AdminCompagnieRepo adminCompagnieRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AdminCompagnie ajout(AdminCompagnie entity) {

        if(!entity.getEmail().contains("@")) {
            throw  new RuntimeException("Votre mail invalide");
        }
        if(!entity.getEmail().contains(".")) {
            throw  new RuntimeException("Votre mail invalide");
        }

        Optional<AdminCompagnie> adminCompagnie = this.adminCompagnieRepo.findByEmail(entity.getEmail());
        if(adminCompagnie.isPresent()) {
            throw  new RuntimeException("Votre mail est déjà utilisé");
        }

        String encodePassword = bCryptPasswordEncoder.encode(entity.getPassword());
        entity.setPassword(encodePassword);

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
            adminCompagnieAModifier.setPassword(entity.getPassword());
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
