package org.odk.g1.pankuru.Service.Service;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Passager;
import org.odk.g1.pankuru.Repository.PassagerRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PassagerService implements CrudService<Passager,Long> {
    private PassagerRepository passagerRepository;
    @Override
    public Passager ajout(Passager passager) {
        return passagerRepository.save(passager);
    }

    @Override
    public List<Passager> liste() {
        return passagerRepository.findAll();
    }

    @Override
    public Optional<Passager> trouverParId(Long id) {
        return passagerRepository.findById(id);
    }

    @Override
    public Passager misAJour(Passager passager) {
        return passagerRepository.findById(passager.getId())
                .map((p)->{
                    p.setNom(p.getNom());
                    p.setPrenom(p.getPrenom());
                    p.setNumeroDeVisa(p.getNumeroDeVisa());
                    p.setNumeroDePassPort(p.getNumeroDePassPort());
                    p.setSiege(p.getSiege());
                    p.setBagage(p.getBagage());
                    return passagerRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Passager introuvable"));
    }

    @Override
    public void supprimer(Long id) {
        passagerRepository.deleteById(id);
    }
}
