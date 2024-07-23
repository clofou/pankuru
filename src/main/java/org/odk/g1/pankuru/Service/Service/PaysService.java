package org.odk.g1.pankuru.Service.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import org.odk.g1.pankuru.Entity.Localite.Pays;
import org.odk.g1.pankuru.Repository.PaysRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaysService implements CrudService<Pays, Integer>{

    private final PaysRepository paysRepository;
    @Override
    public Pays ajout(Pays pays) {
        return paysRepository.save(pays);
    }

    @Override
    public List<Pays> liste() {
        return paysRepository.findAll();
    }

    @Override
    public Optional<Pays> trouverParId(Integer id) {
        return paysRepository.findById(id);
    }

    @Override
    public Pays misAJour(Pays pays) {
        Optional<Pays> paysExistant = paysRepository.findById(pays.getId());
        if (paysExistant.isPresent()) {
            Pays paysAModifier = paysExistant.get();
            paysAModifier.setNom(pays.getNom());

            return paysRepository.save(paysAModifier);
        } else {
            throw new IllegalArgumentException("Le pays avec l'ID " + pays.getId() + "n'existe pas.");
        }
    }

    @Override
    public void supprimer(Integer id) {
        paysRepository.deleteById(id);
    }
    
}
