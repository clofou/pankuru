package org.odk.g1.pankuru.Controller.Paiement;

import org.odk.g1.pankuru.Entity.Paiement.MobileMoney;
import org.odk.g1.pankuru.Service.Paiement.MobileMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/mobileMoney")
public class MobileMoneyController {
    @Autowired
    MobileMoneyService mobileMoneyService;

    @PostMapping("/ajoutMobileMoney")
    public ResponseEntity<MobileMoney> ajouterMobileMoney(@RequestBody MobileMoney mobileMoney) {
        MobileMoney savedMobileMoney = mobileMoneyService.ajout(mobileMoney);
        return ResponseEntity.ok(savedMobileMoney);
    }

    @DeleteMapping("/SuppMobileMoney/{id}")
    public ResponseEntity<String> supprimerMobileMoney(@PathVariable String id) {
        mobileMoneyService.supprimer(id);
        return ResponseEntity.ok("Paiement supprimer avec succes !!!");
    }

    @GetMapping("/listeMobileMoney")
    public List<MobileMoney> listerPaiement() {
        return mobileMoneyService.liste();
    }

    @GetMapping("/afficherUnMobileMoney/{{id}}")
    public MobileMoney afficherUnMobileMoney(@PathVariable String id) {
        return mobileMoneyService.trouverParId(id)
                .orElseThrow(() -> new RuntimeException("Mobile Money non trouvé"));
    }
}
