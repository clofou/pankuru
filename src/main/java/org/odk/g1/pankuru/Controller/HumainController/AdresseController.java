package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Adresse;
import org.odk.g1.pankuru.Service.Service.HumainService.AdresseService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/adresse")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class AdresseController {
    
    private final AdresseService adresseService;

    @PostMapping("/ajout")
    public Adresse ajouter(@RequestBody Adresse adresse){
        return adresseService.ajout(adresse);
    }

    @GetMapping("/afficher")
    public List<Adresse> afficher(){
        return adresseService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Adresse modifier(@PathVariable Long id, @RequestBody Adresse adresse){
        return adresseService.misAJour(adresse, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        adresseService.supprimer(id);
    }
}
