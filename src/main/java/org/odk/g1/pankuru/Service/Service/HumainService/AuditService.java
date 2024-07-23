package org.odk.g1.pankuru.Service.Service.HumainService;

import lombok.Data;
import org.odk.g1.pankuru.Entity.Humain.Audit;
import org.odk.g1.pankuru.Repository.HumainRepo.AuditRepo;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AuditService implements CrudService<Audit, Long> {

    private AuditRepo auditRepo;

    @Override
    public Audit ajout(Audit entity) {
        return auditRepo.save(entity);
    }

    @Override
    public List<Audit> liste() {
        return auditRepo.findAll();
    }

    @Override
    public Optional<Audit> trouverParId(Long aLong) {
        return auditRepo.findById(aLong);
    }

    @Override
    public Audit misAJour(Long aLong, Audit entity) {
        Optional<Audit> audit = auditRepo.findById(aLong);
        Audit audit1;
        if (audit.isEmpty()){
            throw new RuntimeException("L'audit recherché est introuvable");
        }else{
            audit1 = audit.get();
            if(entity.getPersonne() != null) audit1.setPersonne(entity.getPersonne());
            if(entity.getAncienneValeur() != null) audit1.setAncienneValeur(entity.getAncienneValeur());
            if(entity.getNomClasse() != null) audit1.setNomClasse(entity.getNomClasse());
            if(entity.getNouvelleValeur() != null) audit1.setNouvelleValeur(entity.getNouvelleValeur());
            if(entity.getTypeAction() != null) audit1.setTypeAction(entity.getTypeAction());
            if(entity.getIdDuChamp() != null) audit1.setIdDuChamp(entity.getIdDuChamp());
            return auditRepo.save(audit1);
        }
    }

    @Override
    public void supprimer(Long aLong) {

    }
}
