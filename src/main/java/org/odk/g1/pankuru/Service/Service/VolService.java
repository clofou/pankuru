package org.odk.g1.pankuru.Service.Service;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;
import org.odk.g1.pankuru.Repository.VolRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;

import java.util.List;
import java.util.Optional;

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
                    v.setReservation(v.getReservation());
                    v.setSatut(v.getSatut());
                    v.setAeroportDepart(v.getAeroportDepart());
                    v.setDateEtHeureDepart(v.getDateEtHeureDepart());
                    v.setDateEtHeureArrivee(v.getDateEtHeureArrivee());
                    v.setNumeroDeVol(v.getNumeroDeVol());
                    return volRepository.save(v);
                }).orElseThrow(()->new RuntimeException("Vol introuvable"));
    }

    @Override
    public void supprimer(Long aLong) {

    }
}
