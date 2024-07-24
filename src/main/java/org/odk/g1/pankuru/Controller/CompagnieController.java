package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;
import org.odk.g1.pankuru.Service.Service.CompagnieService;
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
@RequestMapping("/compagnie")
@AllArgsConstructor
public class CompagnieController {
    
    private final CompagnieService compagnieService;

    @PostMapping("/ajout")
    public Compagnie ajouter(@RequestBody Compagnie compagnie){
        return compagnieService.ajout(compagnie);
    }

    @GetMapping("/afficher")
    public List<Compagnie> afficher(){
        return compagnieService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Compagnie modifier(@RequestBody Compagnie compagnie){
        return compagnieService.misAJour(compagnie);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        compagnieService.supprimer(id);
    }
}
