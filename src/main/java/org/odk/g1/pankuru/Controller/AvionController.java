package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Compagnie.Avion;
import org.odk.g1.pankuru.Service.Service.AvionService;
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
@RequestMapping("/avion")
@AllArgsConstructor
public class AvionController {
    
    private final AvionService avionService;

    @PostMapping("/ajout")
    public Avion ajouter(@RequestBody Avion avion){
        return avionService.ajout(avion);
    }

    @GetMapping("/afficher")
    public List<Avion> afficher(){
        return avionService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Avion modifier(@PathVariable Integer id,@RequestBody Avion avion){
        return avionService.misAJour(avion, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        avionService.supprimer(id);
    }
}
