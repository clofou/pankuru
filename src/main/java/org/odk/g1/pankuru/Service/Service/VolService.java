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
    public Vol misAJour(Vol vol) {
        return volRepository.findById(vol.getId())
                .map((v)->{
                    v.setReservation(vol.getReservation());
                    v.setSatut(vol.getSatut());
                    v.setAeroportDepart(vol.getAeroportDepart());
                    v.setDateEtHeureDepart(vol.getDateEtHeureDepart());
                    v.setDateEtHeureArrivee(vol.getDateEtHeureArrivee());
                    v.setNumeroDeVol(vol.getNumeroDeVol());
                    return volRepository.save(v);
                }).orElseThrow(()->new RuntimeException("Vol introuvable"));
    }

    @Override
    public void supprimer(Long id) {
        volRepository.deleteById(id);
    }
}
