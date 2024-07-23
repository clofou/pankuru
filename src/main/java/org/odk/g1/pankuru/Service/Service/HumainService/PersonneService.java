package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonneService {
    private PasswordEncoder passwordEncoder;
     private PersonneRepo personneRepo;


    Personne seConnecter(String email, String motDePasse){
        String motDePasseEncode = passwordEncoder.encode(motDePasse);
        return personneRepo.findPersonneByEmailAndMotDePasse(email, motDePasseEncode);
    }
}
