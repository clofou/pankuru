package org.odk.g1.pankuru.Service.Service;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Compagnie.Faq;
import org.odk.g1.pankuru.Repository.FaqRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class FaqService implements CrudService<Faq, Long> {
    private final FaqRepository faqRepository;

    @Override
    public Faq ajout(Faq faq) {
        return faqRepository.save(faq);
    }

    @Override
    public List<Faq> liste() {
        return faqRepository.findAll();
    }

    @Override
    public Optional<Faq> trouverParId(Long id) {
        return faqRepository.findById(id);
    }

    @Override
    public Faq misAJour(Faq faq) {
        // Vérifiez si le Faq existe dans la base
        Optional<Faq> faqExistant = faqRepository.findById(faq.getId());
        if (faqExistant.isPresent()) {
            Faq faqAModifier = faqExistant.get();
            faqAModifier.setQuestionCategorie(faq.getQuestionCategorie());
            faqAModifier.setReponse(faq.getReponse());
            return faqRepository.save(faqAModifier);
        } else {
            // Si le Faq n'existe pas, vous pouvez lancer une exception ou gérer ce cas comme vous le souhaitez
            throw new IllegalArgumentException("Le Faq avec l'ID " + faq.getId() + " n'existe pas.");
        }
    }

    @Override
    public void supprimer(Long id) {
        faqRepository.deleteById(id);
    }
}