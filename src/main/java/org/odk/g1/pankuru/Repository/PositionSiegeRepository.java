package org.odk.g1.pankuru.Repository;

import org.odk.g1.pankuru.Entity.ReservationDeVol.PositionSiege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionSiegeRepository extends JpaRepository<PositionSiege,Integer> {
    PositionSiege findByNom(String nom);
}
