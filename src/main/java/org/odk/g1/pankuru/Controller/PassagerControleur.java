package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Passager;
import org.odk.g1.pankuru.Service.Service.PassagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/passager")
public class PassagerControleur {
    private PassagerService passagerService;
    @PostMapping("/ajout")
    public Passager ajouter(@RequestBody Passager passager){
        return passagerService.ajout(passager);
    }
    @GetMapping("/liste")
    public List<Passager>lire(){
        return passagerService.liste();
    }
    @GetMapping("/liste/{id}")
    public Optional<Passager> parId(@PathVariable Long id){
        return passagerService.trouverParId(id);
    }
    @PutMapping("/modifier")
    public Passager modif(@RequestBody Passager passager){
        return passagerService.misAJour(passager);
    }
    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        passagerService.supprimer(id);
    }

}
