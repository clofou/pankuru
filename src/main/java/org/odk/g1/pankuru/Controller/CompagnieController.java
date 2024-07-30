package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Compagnie.Compagnie;
import org.odk.g1.pankuru.Service.Service.CompagnieService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    public Compagnie modifier(@PathVariable Integer id,@RequestBody Compagnie compagnie){
        return compagnieService.misAJour(compagnie, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        compagnieService.supprimer(id);
    }
}
