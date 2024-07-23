package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Adresse;
import org.odk.g1.pankuru.Service.Service.HumainService.AdresseService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/adresse")
@AllArgsConstructor
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
    public Adresse modifier(@RequestBody Adresse adresse){
        return adresseService.misAJour(adresse);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        adresseService.supprimer(id);
    }
}
