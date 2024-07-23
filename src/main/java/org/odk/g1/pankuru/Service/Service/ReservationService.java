package org.odk.g1.pankuru.Service.Service;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Repository.ReservationRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;

import java.util.List;
import java.util.Optional;

public class ReservationService implements CrudService<Reservation,Long> {
    private ReservationRepository reservationRepository;
    @Override
    public Reservation ajout(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> liste() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> trouverParId(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation misAJour(Reservation reservation) {
        return reservationRepository.findById(reservation.getId())
                .map((r)->{
                    r.setStatut(r.getStatut());
                    r.setVol(r.getVol());
                    r.setDateReservation(r.getDateReservation());
                    r.setDateAnnulation(r.getDateAnnulation());
                    r.setNombreDepassager(r.getNombreDepassager());
                    r.setRaisonAnnulation(r.getRaisonAnnulation());
                    return reservationRepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Reservation introuvable"));
    }

    @Override
    public void supprimer(Long id) {
        reservationRepository.deleteById(id);
    }
}
