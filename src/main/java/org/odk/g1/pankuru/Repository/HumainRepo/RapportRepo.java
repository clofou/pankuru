package org.odk.g1.pankuru.Repository.HumainRepo;

import org.odk.g1.pankuru.Entity.Humain.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepo extends JpaRepository<Rapport, Long> {
}
