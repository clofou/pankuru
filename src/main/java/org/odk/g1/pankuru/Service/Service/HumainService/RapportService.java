package org.odk.g1.pankuru.Service.Service.HumainService;

import java.util.List;
import java.util.Optional;

import org.odk.g1.pankuru.Entity.Humain.Rapport;
import org.odk.g1.pankuru.Repository.HumainRepo.RapportRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RapportService implements CrudService<Rapport, Long>{
    
    private final RapportRepo rapportRepo;
    
    @Override
    public Rapport ajout(Rapport entity) {
        return rapportRepo.save(entity);
    }

    @Override
    public List<Rapport> liste() {
        return rapportRepo.findAll();
    }

    @Override
    public Optional<Rapport> trouverParId(Long id) {
        return rapportRepo.findById(id);
    }

    @Override
    public Rapport misAJour(Rapport entity) {
        Optional<Rapport> rapportExistant = rapportRepo.findById(entity.getId());
        if (rapportExistant.isPresent()) {
            Rapport rapportAModifier = rapportExistant.get();
            rapportAModifier.setTitre(entity.getTitre());
            rapportAModifier.setDateCreation(entity.getDateCreation());
            rapportAModifier.setType(entity.getType());
            rapportAModifier.setUrl(entity.getUrl());
            rapportAModifier.setCommentaires(entity.getCommentaires());

            return rapportRepo.save(rapportAModifier);
        } else {
            throw new IllegalArgumentException("Le rapport avec l'ID " + entity.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Long id) {
        rapportRepo.deleteById(id);
    }
    
}
