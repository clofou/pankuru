package org.odk.g1.pankuru.Repository;

import org.odk.g1.pankuru.Entity.Compagnie.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Integer>{
    
}
