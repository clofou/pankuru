package org.odk.g1.pankuru.Service.Service;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Repository.ReservationRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
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
    public Reservation misAJour(Reservation reservation, Long Id) {
        return reservationRepository.findById(Id)
                .map((r)->{
                    r.setStatut(reservation.getStatut());
                    r.setVol(reservation.getVol());
                    r.setDateReservation(reservation.getDateReservation());
                    r.setDateAnnulation(reservation.getDateAnnulation());
                    r.setNombreDepassager(reservation.getNombreDepassager());
                    r.setRaisonAnnulation(reservation.getRaisonAnnulation());
                    return reservationRepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Reservation introuvable"));
    }

    @Override
    public void supprimer(Long id) {
        reservationRepository.deleteById(id);
    }
}
