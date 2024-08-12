package org.odk.g1.pankuru.Repository;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolRepository extends JpaRepository<Vol,Long> {
    List<Vol> findByAdminCompagnieId(Long adminCompagnieId);
}
