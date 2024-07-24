package org.odk.g1.pankuru.Controller.Paiement;

import org.odk.g1.pankuru.Entity.Paiement.CarteBancaire;
import org.odk.g1.pankuru.Entity.Paiement.Paiement;
import org.odk.g1.pankuru.Service.Paiement.CarteBancaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/carteBancaire")
public class CarteBancaireController {
    @Autowired
    CarteBancaireService carteBancaireService;

    @PostMapping("/ajoutCarteBancaire")
    public ResponseEntity<CarteBancaire> ajouterCarteBancaire(@RequestBody CarteBancaire carteBancaire) {
        CarteBancaire savedCarteBancaire = carteBancaireService.ajout(carteBancaire);
        return ResponseEntity.ok(savedCarteBancaire);
    }

    @DeleteMapping("/SuppCarteBancaire/{id}")
    public ResponseEntity<String> supprimerCarteBancaire(@PathVariable String id) {
        carteBancaireService.supprimer(id);
        return ResponseEntity.ok("Paiement supprimer avec succes !!!");
    }

    @GetMapping("/listeCarteBancaire")
    public List<CarteBancaire> listerPaiement() {
        return carteBancaireService.liste();
    }

    @GetMapping("/afficherUneCarteBancaire/{{id}}")
    public CarteBancaire afficherUneCarteBancaire(@PathVariable String id) {
        return carteBancaireService.trouverParId(id)
                .orElseThrow(() -> new RuntimeException("Carte bancaire non trouvé"));
    }
}
