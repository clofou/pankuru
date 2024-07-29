package org.odk.g1.pankuru.Service.Service;

import java.util.List;
import java.util.Optional;

import org.odk.g1.pankuru.Entity.Compagnie.Avion;
import org.odk.g1.pankuru.Repository.AvionRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AvionService implements CrudService<Avion, Integer>{

    private final AvionRepository avionRepository;

    @Override
    public Avion ajout(Avion avion) {
        return avionRepository.save(avion);
    }

    @Override
    public List<Avion> liste() {
        return avionRepository.findAll();
    }

    @Override
    public Optional<Avion> trouverParId(Integer id) {
        return avionRepository.findById(id);
    }

    @Override
    public Avion misAJour(Avion avion, Integer Id) {
        Optional<Avion> avionExistant = avionRepository.findById(Id);
        if (avionExistant.isPresent()) {
            Avion avionAModifier = avionExistant.get();
            avionAModifier.setMatricule(avion.getMatricule());
            avionAModifier.setCapaciteTotale(avion.getCapaciteTotale());
            avionAModifier.setNom(avion.getNom());
            avionAModifier.setStatut(avion.getStatut());

            return avionRepository.save(avionAModifier);
        } else {
            throw new IllegalArgumentException("L'avion avec l'ID " + avion.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Integer id) {
        avionRepository.deleteById(id);
    }

    
}
