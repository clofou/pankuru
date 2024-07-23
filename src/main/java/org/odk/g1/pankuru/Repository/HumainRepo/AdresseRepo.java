package org.odk.g1.pankuru.Repository.HumainRepo;

import org.odk.g1.pankuru.Entity.Humain.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Long> {
}
