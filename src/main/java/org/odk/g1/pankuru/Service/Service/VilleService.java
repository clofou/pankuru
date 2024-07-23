package org.odk.g1.pankuru.Service.Service;

import java.util.List;
import java.util.Optional;
import org.odk.g1.pankuru.Entity.Localite.Ville;
import org.odk.g1.pankuru.Repository.VilleRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VilleService implements CrudService<Ville, Integer>{
    private final VilleRepository villeRepository;

    @Override
    public Ville ajout(Ville ville) {
        return villeRepository.save(ville);
    }

    @Override
    public List<Ville> liste() {
        return villeRepository.findAll();
    }

    @Override
    public Optional<Ville> trouverParId(Integer id) {
        return villeRepository.findById(id);
    }

    @Override
    public Ville misAJour(Ville ville) {
        Optional<Ville> villeExistant = villeRepository.findById(ville.getId());
        if (villeExistant.isPresent()) {
            Ville villeAModifier = villeExistant.get();
            villeAModifier.setNom(ville.getNom());

            return villeRepository.save(villeAModifier);
        } else {
            throw new IllegalArgumentException("La ville avec l'ID " + ville.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Integer id) {
        villeRepository.deleteById(id);
    }

    
    
}
