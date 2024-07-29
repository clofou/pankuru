package org.odk.g1.pankuru.Controller;

import java.util.*;
import org.odk.g1.pankuru.Entity.Compagnie.Contrat;
import org.odk.g1.pankuru.Service.Service.ContratService;
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
@RequestMapping("/contrat")
@AllArgsConstructor
public class ContratController {

    private final ContratService contratService;

    @PostMapping("/ajout")
    public Contrat ajouter(@RequestBody Contrat contrat){
        return contratService.ajout(contrat);
    }

    @GetMapping("/afficher")
    public List<Contrat> afficher(){
        return contratService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Contrat modifier(@PathVariable Long id,@RequestBody Contrat contrat){
        return contratService.misAJour(contrat, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        contratService.supprimer(id);
    }
}
