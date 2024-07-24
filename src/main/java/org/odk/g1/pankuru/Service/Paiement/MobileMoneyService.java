package org.odk.g1.pankuru.Service.Paiement;

import org.odk.g1.pankuru.Entity.Paiement.CarteBancaire;
import org.odk.g1.pankuru.Entity.Paiement.MobileMoney;
import org.odk.g1.pankuru.Repository.Paiement.MobileMoneyRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MobileMoneyService implements CrudService<MobileMoney, String> {
    @Autowired
    MobileMoneyRepository mobileMoneyRepository;
    
    @Override
    public MobileMoney ajout(MobileMoney mobileMoney) {
        return mobileMoneyRepository.save(mobileMoney);
    }

    @Override
    public List<MobileMoney> liste() {
        return mobileMoneyRepository.findAll();
    }

    @Override
    public Optional<MobileMoney> trouverParId(String mobileMoneyId) {
        return mobileMoneyRepository.findById(mobileMoneyId);
    }

    @Override
    public MobileMoney misAJour(MobileMoney entity, Long Id) {
        return null;
    }

    @Override
    public CarteBancaire misAJour(CarteBancaire newInfoCarteBancaire, String Id) {
        return null;
    }

    @Override
    public MobileMoney misAJour(MobileMoney newInfoMobileMoney, String mobileMoneyId) {
        MobileMoney mobileMoneyBD = mobileMoneyRepository.getReferenceById(mobileMoneyId);

        if (newInfoMobileMoney.getNumeroDeTelephone() != null &&
                !newInfoMobileMoney.getNumeroDeTelephone().isEmpty() &&
                !Objects.equals(newInfoMobileMoney.getNumeroDeTelephone(), mobileMoneyBD.getNumeroDeTelephone())) {
            mobileMoneyBD.setNumeroDeTelephone(newInfoMobileMoney.getNumeroDeTelephone());
        }
        if (newInfoMobileMoney.getPaiements() != null &&
                !newInfoMobileMoney.getPaiements().isEmpty() &&
                !Objects.equals(newInfoMobileMoney.getPaiements(), mobileMoneyBD.getPaiements())) {
            mobileMoneyBD.setPaiements(newInfoMobileMoney.getPaiements());
        }
        return null;
    }

    @Override
    public void supprimer(String mobileMoneyId) {
        MobileMoney mobileMoney =mobileMoneyRepository
                .getReferenceById(mobileMoneyId);
        mobileMoneyRepository.delete(mobileMoney);
    }
}
