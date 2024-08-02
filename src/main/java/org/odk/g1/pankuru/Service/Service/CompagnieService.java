package org.odk.g1.pankuru.Service.Service;

import java.util.List;
import java.util.Optional;

import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;
import org.odk.g1.pankuru.Repository.CompagnieRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompagnieService implements CrudService<Compagnie, Integer>{

    private final CompagnieRepository compagnieRepository;
    @Override
    public Compagnie ajout(Compagnie compagnie) {
        return compagnieRepository.save(compagnie);
    }

    @Override
    public List<Compagnie> liste() {
        return compagnieRepository.findAll();
    }

    @Override
    public Optional<Compagnie> trouverParId(Integer id) {
        return compagnieRepository.findById(id);
    }

    @Override
    public Compagnie misAJour(Compagnie compagnie, Integer Id) {
        if (Id == null) {
            throw new IllegalArgumentException("L'identifiant de la compagnie ne doit pas être nul.");
        }
        Optional<Compagnie> compagnieExistant = compagnieRepository.findById(Id);
        if (compagnieExistant.isPresent()) {
            Compagnie compagnieAModifier = compagnieExistant.get();
            compagnieAModifier.setMatricule(compagnie.getMatricule());
            compagnieAModifier.setNom(compagnie.getNom());
            compagnieAModifier.setLogoUrl(compagnie.getLogoUrl());
            compagnieAModifier.setCodeIATA(compagnie.getCodeIATA());
            compagnieAModifier.setCodeICAO(compagnie.getCodeICAO());
            compagnieAModifier.setNumeroTelephone(compagnie.getNumeroTelephone());
            compagnieAModifier.setEmail(compagnie.getEmail());
            compagnieAModifier.setSiteWeb(compagnie.getSiteWeb());
            compagnieAModifier.setNumeroLicence(compagnie.getNumeroLicence());

            return compagnieRepository.save(compagnieAModifier);
        } else {
            throw new IllegalArgumentException("La compagnie avec l'ID " + compagnie.getId() + " n'existe pas.");
        }
    }

    @Override
    public void supprimer(Integer id) {
        compagnieRepository.deleteById(id);
    }
    
}
