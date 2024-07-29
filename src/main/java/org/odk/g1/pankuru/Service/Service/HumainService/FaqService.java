package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Faq;
import org.odk.g1.pankuru.Repository.HumainRepo.FaqRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FaqService implements CrudService<Faq, Integer> {
    private final FaqRepo rapportRepo;

    @Override
    public Faq ajout(Faq entity) {
        return rapportRepo.save(entity);
    }

    @Override
    public List<Faq> liste() {
        return rapportRepo.findAll();
    }

    @Override
    public Optional<Faq> trouverParId(Integer integer) {
        return rapportRepo.findById(integer);
    }

    @Override
    public Faq misAJour(Faq entity, Integer Id) {
        Optional<Faq> rapportExistant = rapportRepo.findById(Id);
        if (rapportExistant.isPresent()) {
            Faq rapportAModifier = rapportExistant.get();
            rapportAModifier.setAdminCompagnie(entity.getAdminCompagnie());
            rapportAModifier.setReponse(entity.getReponse());
            rapportAModifier.setQuestionCategorie(entity.getQuestionCategorie());
            return rapportRepo.save(rapportAModifier);
        } else {
            throw new IllegalArgumentException("Le rapport avec l'ID " + entity.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Integer integer) {
        rapportRepo.deleteById(integer);
    }

}
