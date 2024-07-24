package org.odk.g1.pankuru.Service.Service;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Siege;
import org.odk.g1.pankuru.Repository.SiegeRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;

import java.util.List;
import java.util.Optional;

public class SiegeService implements CrudService<Siege,Long> {
    private SiegeRepository siegeRepository;
    @Override
    public Siege ajout(Siege siege) {
        return siegeRepository.save(siege);
    }

    @Override
    public List<Siege> liste() {
        return siegeRepository.findAll();
    }

    @Override
    public Optional<Siege> trouverParId(Long id) {
        return siegeRepository.findById(id);
    }

    @Override
    public Siege misAJour(Siege siege) {
        return siegeRepository.findById(siege.getId())
                .map((s)->{
                    s.setDisponibilite(s.getDisponibilite());
                    s.setNumero(s.getNumero());
                    s.setPassager(s.getPassager());
                    s.setPositionSiege(s.getPositionSiege());
                    return siegeRepository.save(s);
                }).orElseThrow(()->new RuntimeException("Siege introuvable"));
    }

    @Override
    public void supprimer(Long id) {
        siegeRepository.deleteById(id);
    }
}
