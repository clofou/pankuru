package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonneService implements CrudService<Personne, Long> {
    private PersonneRepo personneRepo;
    

    @Override
    public Personne ajout(Personne entity) {
        return null;
    }

    @Override
    public List<Personne> liste() {
        return personneRepo.findAll();
    }

    @Override
    public Optional<Personne> trouverParId(Long aLong) {
        return personneRepo.findById(aLong);
    }

    @Override
    public Personne misAJour(Personne entity, Long Id) {
        return null;
    }

    @Override
    public void supprimer(Long aLong) {
        personneRepo.deleteById(aLong);
    }
    public String generateToken(Personne personne) {
        try {
            String tokenData = personne.getEmail() + ":" + personne.getPassword() + ":" + System.currentTimeMillis();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(tokenData.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }
}
