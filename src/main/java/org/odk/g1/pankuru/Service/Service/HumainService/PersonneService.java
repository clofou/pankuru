package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonneService implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private PersonneRepo personneRepo;

    public void save(Personne personne) {

        String mdpCrypte = this.bCryptPasswordEncoder.encode(personne.getPassword());
        personne.setPassword(mdpCrypte);

        personneRepo.save(personne);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.personneRepo
                .findByEmail(username)
                .orElseThrow(() -> new  UsernameNotFoundException("Aucun utilisateur ne corespond à cet identifiant")
        );
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
