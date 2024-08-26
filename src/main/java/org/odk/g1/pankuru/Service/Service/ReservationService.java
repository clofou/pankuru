package org.odk.g1.pankuru.Service.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Enum.Statut;
import org.odk.g1.pankuru.Entity.Humain.Notification;
import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;
import org.odk.g1.pankuru.Repository.HumainRepo.UtilisateurRepo;
import org.odk.g1.pankuru.Repository.NotificationRepository;
import org.odk.g1.pankuru.Repository.ReservationRepository;
import org.odk.g1.pankuru.Repository.VolRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ReservationService implements CrudService<Reservation,Long> {
    private ReservationRepository reservationRepository;
    private UserService userService;
    private VolRepository volRepository;
    private UtilisateurRepo utilisateurRepo;
    private NotificationRepository notificationRepository;


    @Override
    public Reservation ajout(Reservation reservation) {
        Long userId = userService.getCurrentUsernameId();

        // Vérifier si l'utilisateur existe
        Utilisateur utilisateur = utilisateurRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé pour l'ID : " + userId));

        // Lier l'utilisateur à la réservation
        reservation.setUtilisateur(utilisateur);

        // Sauvegarder la réservation
        Reservation reservationSaved = reservationRepository.save(reservation);

        // Récupérer le vol lié à la réservation
        Long volId = reservationSaved.getVol().getId();
        Vol vol = volRepository.findById(volId)
                .orElseThrow(() -> new EntityNotFoundException("Vol non trouvé pour l'ID : " + volId));

        // Créer une notification pour l'utilisateur
        Notification notification = new Notification();
        notification.setUtilisateur(utilisateur);
        notification.setReservation(reservationSaved);
        notification.setDate(LocalDate.now());
        notification.setHeure(LocalTime.now());
        notification.setObjet("Réservation de vol");
        notification.setVol(vol);

        // Sauvegarder la notification
        notificationRepository.save(notification);

        return reservationSaved;
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

    @Transactional
    public void annulerReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("Réservation non trouvée pour l'ID : " + reservationId));

        // Vérifier si la réservation est déjà annulée
        if (reservation.getStatut() == Statut.ANNULER) {
            throw new IllegalStateException("La réservation a déjà été annulée");
        }

        // Mettre à jour les champs pour annuler la réservation
        reservation.setStatut(Statut.ANNULER);  // Statut de l'annulation
        reservation.setDateAnnulation(new Date());  // Date actuelle comme date d'annulation

        // Enregistrer les modifications
        reservationRepository.save(reservation);

        // Créer une notification pour l'utilisateur
        Notification notification = new Notification();
        notification.setUtilisateur(reservation.getUtilisateur());
        notification.setReservation(reservation);
        notification.setDate(LocalDate.now());
        notification.setHeure(LocalTime.now());
        notification.setObjet("Annulation de réservation");

        notificationRepository.save(notification);
    }

}
