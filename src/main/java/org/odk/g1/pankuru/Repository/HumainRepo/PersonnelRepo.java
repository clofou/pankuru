package org.odk.g1.pankuru.Repository.HumainRepo;

// import jakarta.persistence.Entity;
import org.odk.g1.pankuru.Entity.Humain.Personnel;
import org.odk.g1.pankuru.Entity.Localite.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelRepo extends JpaRepository<Personnel, Long> {
    List<Personnel> findByAdminCompagnieId(Long adminCompagnieId);
}
