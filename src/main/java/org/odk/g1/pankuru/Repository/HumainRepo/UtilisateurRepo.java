package org.odk.g1.pankuru.Repository.HumainRepo;

import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    @Query("select u.nom as nom, u.prenom as prenom, u.numeroDePassport as numeroDePassport, u.numeroDeVisa as numeroDeVisa, u.pointDeFideliter as pointDeFideliter, u.numeroDeTelephone as numeroDeTelephone, r.nom as role, a.ville as ville, a.rue as rue from Utilisateur u join u.role r join u.adresse a")
    List<Map<String, Object>> tout();
}
