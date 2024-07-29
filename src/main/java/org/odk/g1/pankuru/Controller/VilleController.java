package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Localite.Ville;
import org.odk.g1.pankuru.Service.Service.VilleService;
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
@RequestMapping("/ville")
@AllArgsConstructor
public class VilleController {
    
    private final VilleService villeService;

    @PostMapping("/ajout")
    public Ville ajouter(@RequestBody Ville ville){
        return villeService.ajout(ville);
    }

    @GetMapping("/afficher")
    public List<Ville> afficher(){
        return villeService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Ville modifier(@PathVariable Integer id,@RequestBody Ville ville){
        return villeService.misAJour(ville, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        villeService.supprimer(id);
    }
}
