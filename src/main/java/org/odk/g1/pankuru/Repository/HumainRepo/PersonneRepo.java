package org.odk.g1.pankuru.Repository.HumainRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepo extends JpaRepository<PersonneRepo, Long> {
}
