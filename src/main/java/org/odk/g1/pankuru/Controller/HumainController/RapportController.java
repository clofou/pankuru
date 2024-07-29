package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Rapport;
import org.odk.g1.pankuru.Service.Service.HumainService.RapportService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rapport")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class RapportController {
    
    private final RapportService rapportService;

    @PostMapping("/ajout")
    public Rapport ajouter(@RequestBody Rapport rapport){
        return rapportService.ajout(rapport);
    }

    @GetMapping("/afficher")
    public List<Rapport> afficher(){
        return rapportService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Rapport modifier(@RequestBody Rapport rapport){
        return rapportService.misAJour(rapport);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        rapportService.supprimer(id);
    }
}
