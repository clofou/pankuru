package org.odk.g1.pankuru.Repository.HumainRepo;

import org.odk.g1.pankuru.Entity.Humain.AdminCompagnie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCompagnieRepo extends JpaRepository<AdminCompagnie, Long> {
}
