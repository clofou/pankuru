package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.odk.g1.pankuru.Utils.UtilService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonneService implements CrudService<Personne, Long> {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
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
}
