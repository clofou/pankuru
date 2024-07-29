package org.odk.g1.pankuru.SecurityConfig;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    PersonneRepo personneRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne personne = personneRepo.findByEmail(username);
        if (personne == null) {throw new UsernameNotFoundException(username);}
        return User.withUsername(personne.getEmail()).roles(personne.getRole().getNom()).build();
    }
}
