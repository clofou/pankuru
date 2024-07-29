package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Compagnie.Avion;
import org.odk.g1.pankuru.Service.Service.AvionService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/avion")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
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
    public Avion modifier(@RequestBody Avion avion){
        return avionService.misAJour(avion);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        avionService.supprimer(id);
    }
}
