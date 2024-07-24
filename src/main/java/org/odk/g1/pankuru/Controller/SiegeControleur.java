package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Siege;
import org.odk.g1.pankuru.Service.Service.SiegeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/siege")
public class SiegeControleur {
    private SiegeService siegeService;
    @PostMapping("/ajout")
    public Siege ajouter(@RequestBody Siege siege){
        return siegeService.ajout(siege);
    }
    @GetMapping("/liste")
    public List<Siege>lire(){
        return siegeService.liste();
    }

    @GetMapping("/liste/{id}")
    public Optional<Siege> parId(@PathVariable Long id){
        return siegeService.trouverParId(id);
    }

    @PutMapping("/modifier")
    public Siege modi(@RequestBody Siege siege){
        return siegeService.misAJour(siege);
    }
    @DeleteMapping("/supprimer")
    public void supp(@PathVariable Long id){
        siegeService.supprimer(id);
    }
}
