package org.odk.g1.pankuru.Service.Service;

import org.odk.g1.pankuru.Entity.ReservationDeVol.PositionSiege;
import org.odk.g1.pankuru.Repository.PositionSiegeRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;

import java.util.List;
import java.util.Optional;

public class PositionSiegeService implements CrudService<PositionSiege,Integer> {
    private PositionSiegeRepository positionSiegeRepository;
    @Override
    public PositionSiege ajout(PositionSiege position) {
        return positionSiegeRepository.save(position);
    }

    @Override
    public List<PositionSiege> liste() {
        return positionSiegeRepository.findAll();
    }

    @Override
    public Optional<PositionSiege> trouverParId(Integer id) {
        return positionSiegeRepository.findById(id);
    }

    @Override
    public PositionSiege misAJour(PositionSiege positionSiege) {
        return positionSiegeRepository.findById(positionSiege.getId())
                .map((p)->{
                    p.setSiege(p.getSiege());
                    p.setNom(p.getNom());
                    p.setClasse(p.getClasse());
                    return positionSiegeRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Position introuvable"));
    }

    @Override
    public void supprimer(Integer id) {
        positionSiegeRepository.deleteById(id);
    }
}
