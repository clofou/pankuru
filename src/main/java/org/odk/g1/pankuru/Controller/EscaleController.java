package org.odk.g1.pankuru.Controller;


import lombok.AllArgsConstructor;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Escale;
import org.odk.g1.pankuru.Service.Service.EscaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/escale")
@AllArgsConstructor
public class EscaleController {

    private final EscaleService escaleService;

    @PostMapping("/ajout")
    public Escale ajouter(@RequestBody Escale escale){
        return escaleService.ajout(escale);
    }

    @GetMapping("/afficher")
    public List<Escale> afficher(){
        return escaleService.liste();
    }

    @PutMapping("/modifier/{id}")
    public Escale modifier(@RequestBody Escale escale){
        return escaleService.misAJour(escale);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        escaleService.supprimer(id);
    }
}
