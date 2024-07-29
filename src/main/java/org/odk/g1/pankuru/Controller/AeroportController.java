package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Localite.Aeroport;
import org.odk.g1.pankuru.Service.Service.AeroportService;
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
@RequestMapping("/aeroport")
@AllArgsConstructor
public class AeroportController {
    private final AeroportService aeroportService;

    @PostMapping("/ajout")
    public Aeroport ajouter(@RequestBody Aeroport aeroport){
        return aeroportService.ajout(aeroport);
    }

    @GetMapping("/afficher")
    public List<Aeroport> afficher(){
        return aeroportService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Aeroport modifier(@PathVariable Long id,@RequestBody Aeroport aeroport){
        return aeroportService.misAJour(aeroport, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        aeroportService.supprimer(id);
    }
}
