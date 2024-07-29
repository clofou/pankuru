package org.odk.g1.pankuru.Service.Service;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;
import org.odk.g1.pankuru.Repository.VolRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VolService implements CrudService<Vol,Long> {
    private VolRepository volRepository;
    @Override
    public Vol ajout(Vol vol) {
        return volRepository.save(vol);
    }

    @Override
    public List<Vol> liste() {
        return volRepository.findAll();
    }

    @Override
    public Optional<Vol> trouverParId(Long id) {
        return volRepository.findById(id);
    }

    @Override
    public Vol misAJour(Vol vol, Long Id) {
        return volRepository.findById(Id)
                .map((v)->{
                    v.setReservationList(v.getReservationList());
                    v.setSatut(v.getSatut());
                    v.setAeroportDepart(v.getAeroportDepart());
                    v.setDateEtHeureDepart(v.getDateEtHeureDepart());
                    v.setDateEtHeureArrivee(v.getDateEtHeureArrivee());
                    v.setNumeroDeVol(v.getNumeroDeVol());

                    return volRepository.save(v);
                }).orElseThrow(()->new RuntimeException("Vol introuvable"));
    }

    @Override
    public void supprimer(Long id) {
        volRepository.deleteById(id);
    }
}
