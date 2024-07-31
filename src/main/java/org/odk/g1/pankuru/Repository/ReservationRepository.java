package org.odk.g1.pankuru.Repository;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("select r.id as id, r.dateReservation as dateReservation, r.nombreDepassager as nombreDepassager, r.raisonAnnulation as raisonAnnulation, r.statut as statut, p.datePaiement, u.email from Reservation r join r.paiement p join r.utilisateur u")
    List<Map<String, Object>> tout();
}
