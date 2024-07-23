package org.odk.g1.pankuru.Repository.HumainRepo;

import jakarta.persistence.Entity;
import org.odk.g1.pankuru.Entity.Humain.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepo extends JpaRepository<Personnel, Long> {
}
