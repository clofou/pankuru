package org.odk.g1.pankuru.Repository.HumainRepo;

import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepo extends JpaRepository<Personne, Long> {
    Personne findPersonneByEmailAndPassword(String email, String password);

    Optional<Personne> findByEmail(String email);
}
