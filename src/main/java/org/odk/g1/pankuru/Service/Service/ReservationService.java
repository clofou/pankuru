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
    private UtilisateurRepo utilisateurRepo;


    @Override
    public Reservation ajout(Reservation reservation) {
        Long userId = userService.getCurrentUsernameId();
        System.out.print("============================================ ");
        System.out.println(userId);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(userId);
        reservation.setUtilisateur(utilisateur);

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> liste() {
        Long userId = userService.getCurrentUsernameId();
        return reservationRepository.findReservationByUtilisateurId(userId);
    }

    public List<Map<String, Object>> liste1() {

        return reservationRepository.tout();
    }

    @Override
    public Optional<Reservation> trouverParId(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Map<String, Object>> trouverParId1(Long id) {
        return reservationRepository.trouverParId(id);
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
