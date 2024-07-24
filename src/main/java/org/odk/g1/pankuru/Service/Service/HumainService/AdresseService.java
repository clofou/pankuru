package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.Data;
import org.odk.g1.pankuru.Entity.Humain.Adresse;
import org.odk.g1.pankuru.Repository.HumainRepo.AdresseRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AdresseService implements CrudService<Adresse, Long> {
    private AdresseRepo adresseRepo;

    @Override
    public Adresse ajout(Adresse entity) {
        return adresseRepo.save(entity);
    }

    @Override
    public List<Adresse> liste() {
        return adresseRepo.findAll();
    }

    @Override
    public Optional<Adresse> trouverParId(Long aLong) {
        return adresseRepo.findById(aLong);
    }

    @Override
    public Adresse misAJour(Adresse entity) {
        Optional<Adresse> adresse = adresseRepo.findById(entity.getId());
        Adresse adresse1;
        if (adresse.isEmpty()){
            throw new RuntimeException("L'adresse recherché est introuvable");
        }else{
            adresse1 = adresse.get();
            if(entity.getEtat() != null) adresse1.setEtat(entity.getEtat());
            if(entity.getRue() != null) adresse1.setRue(entity.getRue());
            if(entity.getPays() != null) adresse1.setPays(entity.getPays());
            if(entity.getPersonne() != null) adresse1.setPersonne(entity.getPersonne());
            if(entity.getVille() != null) adresse1.setVille(entity.getVille());
            if(entity.getCodePostal() != null) adresse1.setCodePostal(entity.getCodePostal());
            return adresseRepo.save(adresse1);
        }

    }

    @Override
    public void supprimer(Long aLong) {
        adresseRepo.deleteById(aLong);
    }
}
