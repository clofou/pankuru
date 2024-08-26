package org.odk.g1.pankuru.Service.Service.Paiement;

// import org.odk.g1.pankuru.Entity.Paiement.CarteBancaire;
import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Paiement.MobileMoney;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Repository.Paiement.MobileMoneyRepository;
import org.odk.g1.pankuru.Repository.ReservationRepository;
import org.odk.g1.pankuru.Service.Interface.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MobileMoneyService implements CrudService<MobileMoney, Long> {
    MobileMoneyRepository mobileMoneyRepository;
    private ReservationRepository reservationRepository;

    @Override
    public MobileMoney ajout(MobileMoney mobileMoney) {
        Reservation r=new Reservation();
        r.setId(reservationRepository.findLastInsertedId());
        mobileMoney.setReservation(r);
        return mobileMoneyRepository.save(mobileMoney);
    }

    @Override
    public List<MobileMoney> liste() {
        return mobileMoneyRepository.findAll();
    }

    @Override
    public Optional<MobileMoney> trouverParId(Long mobileMoneyId) {
        return mobileMoneyRepository.findById(mobileMoneyId);
    }

    @Override
    public MobileMoney misAJour(MobileMoney newInfoMobileMoney, Long Id) {
        MobileMoney mobileMoneyBD = mobileMoneyRepository.getReferenceById(Id);

        if (newInfoMobileMoney.getNumeroDeTelephone() != null &&
                !newInfoMobileMoney.getNumeroDeTelephone().isEmpty() &&
                !Objects.equals(newInfoMobileMoney.getNumeroDeTelephone(), mobileMoneyBD.getNumeroDeTelephone())) {
            mobileMoneyBD.setNumeroDeTelephone(newInfoMobileMoney.getNumeroDeTelephone());
        }
       // if (newInfoMobileMoney.getPaiementList() != null &&
         //       !newInfoMobileMoney.getPaiementList().isEmpty() &&
           //     !Objects.equals(newInfoMobileMoney.getPaiementList(), mobileMoneyBD.getPaiementList())) {
            //mobileMoneyBD.setPaiementList(newInfoMobileMoney.getPaiementList());
        //}
        return null;
    }

    @Override
    public void supprimer(Long mobileMoneyId) {
        MobileMoney mobileMoney =mobileMoneyRepository
                .getReferenceById(mobileMoneyId);
        mobileMoneyRepository.delete(mobileMoney);
    }
}
