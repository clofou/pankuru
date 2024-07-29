package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Rapport;
import org.odk.g1.pankuru.Service.Service.HumainService.RapportService;
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
@RequestMapping("/rapport")
@AllArgsConstructor
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
    public Rapport modifier(@PathVariable Long id,@RequestBody Rapport rapport){
        return rapportService.misAJour(rapport, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        rapportService.supprimer(id);
    }
}
