package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Localite.Aeroport;
import org.odk.g1.pankuru.Service.Service.AeroportService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("http://localhost:4200")
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
    public Aeroport modifier(@RequestBody Aeroport aeroport){
        return aeroportService.misAJour(aeroport);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        aeroportService.supprimer(id);
    }
}
