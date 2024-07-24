package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
