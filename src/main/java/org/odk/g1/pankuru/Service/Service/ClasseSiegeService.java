package org.odk.g1.pankuru.Service.Service;

import org.odk.g1.pankuru.Entity.ReservationDeVol.ClasseSiege;
import org.odk.g1.pankuru.Repository.ClasseSiegeRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;

import java.util.List;
import java.util.Optional;

public class ClasseSiegeService implements CrudService<ClasseSiege,Integer> {
     private  ClasseSiegeRepository classeSiegeRepository;
    @Override
    public ClasseSiege ajout(ClasseSiege classeSiege) {
        return classeSiegeRepository.save(classeSiege);
    }

    @Override
    public List<ClasseSiege> liste() {
        return classeSiegeRepository.findAll();
    }

    @Override
    public Optional<ClasseSiege> trouverParId(Integer id) {
        return classeSiegeRepository.findById(id);
    }

    @Override
    public ClasseSiege misAJour(ClasseSiege classeSiege) {
        return classeSiegeRepository.findById(classeSiege.getId())
                .map((c)->{
                    c.setNom(c.getNom());
                    c.setPositionSiege(c.getPositionSiege());
                    return classeSiegeRepository.save(c);
                }).orElseThrow(()->{new RuntimeException("Classe introuvable");
                return null;
                });
    }

    @Override
    public void supprimer(Integer id) {
        classeSiegeRepository.deleteById(id);
    }
}
