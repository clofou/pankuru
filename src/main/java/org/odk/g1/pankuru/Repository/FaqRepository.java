package org.odk.g1.pankuru.Repository;

import org.odk.g1.pankuru.Entity.Humain.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {
}