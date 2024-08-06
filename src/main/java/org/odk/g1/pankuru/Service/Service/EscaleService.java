package org.odk.g1.pankuru.Service.Service;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Compagnie.Avion;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Escale;
import org.odk.g1.pankuru.Repository.EscaleRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class EscaleService implements CrudService<Escale, Long> {

    private final EscaleRepository escaleRepository;

    @Override
    public Escale ajout(Escale escale) {
        return escaleRepository.save(escale);
    }

    @Override
    public List<Escale> liste() {
        return escaleRepository.findAll();
    }

    @Override
    public Optional<Escale> trouverParId(Long id) {
        return escaleRepository.findById(id);
    }

    @Override
    public Escale misAJour(Escale escale) {
        Optional<Escale> escaleExistant = escaleRepository.findById(escale.getId());
        if (escaleExistant.isPresent()) {
            Escale escaleAModifier = escaleExistant.get();
            escaleAModifier.setDateEtHeure(escale.getDateEtHeure());
            return escaleRepository.save(escaleAModifier);
        } else {
            throw new IllegalArgumentException("L'escale avec l'ID " + escale.getId() + "n'existe pas.");
        }

    }

    @Override
    public void supprimer(Long id) {
        escaleRepository.deleteById(id);
    }



}
