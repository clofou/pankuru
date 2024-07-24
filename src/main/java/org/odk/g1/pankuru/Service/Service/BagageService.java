package org.odk.g1.pankuru.Service.Service;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Bagage;
import org.odk.g1.pankuru.Repository.BagageRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BagageService implements CrudService<Bagage,Long> {
    private BagageRepository bagageRepository;
    @Override
    public Bagage ajout(Bagage bagage) {
        return bagageRepository.save(bagage);
    }

    @Override
    public List<Bagage> liste() {
        return bagageRepository.findAll();
    }

    @Override
    public Optional<Bagage> trouverParId(Long id) {
        return bagageRepository.findById(id);
    }

    @Override
    public Bagage misAJour(Bagage bagage) {
        return bagageRepository.findById(bagage.getId())
                .map((b)->{
                    b.setPoids(bagage.getPoids());
                    b.setDimension(b.getDimension());
                    b.setTypeBagage(b.getTypeBagage());
                    b.setPassager(b.getPassager());
                    return bagageRepository.save(b);
                }).orElseThrow(()->{new RuntimeException("Bagage inexistant");
                    return null;
                });
    }

    @Override
    public void supprimer(Long id) {
        bagageRepository.deleteById(id);
    }
}
