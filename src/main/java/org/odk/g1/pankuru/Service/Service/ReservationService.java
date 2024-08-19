package org.odk.g1.pankuru.Service.Service;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Repository.HumainRepo.UtilisateurRepo;
import org.odk.g1.pankuru.Repository.ReservationRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ReservationService implements CrudService<Reservation,Long> {
    private ReservationRepository reservationRepository;
    private UserService userService;


    @Override
    public Reservation ajout(Reservation reservation) {
        Long userId = userService.getCurrentUsernameId();

        Utilisateur u = new Utilisateur();
        u.setId(userId);

        reservation.setUtilisateur(u);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> liste() {
        Long userId = userService.getCurrentUsernameId();
        return reservationRepository.findReservationByUtilisateurId(userId);
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

    public List<Reservation> getReservationsByPassager(Long utilisateurId) {
        return reservationRepository.findByutilisateurId(utilisateurId);
    }
}
