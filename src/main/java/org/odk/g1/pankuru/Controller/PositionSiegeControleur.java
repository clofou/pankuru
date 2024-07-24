package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.PositionSiege;
import org.odk.g1.pankuru.Service.Service.PositionSiegeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/position")
public class PositionSiegeControleur {
    private PositionSiegeService positionSiegeService;
    @PostMapping("/ajout")
    public PositionSiege ajouter(PositionSiege positionSiege){
        return positionSiegeService.ajout(positionSiege);
    }
    @GetMapping("/liste")
    public List<PositionSiege> lire(){
        return positionSiegeService.liste();


    }
    @GetMapping("/liste/{id}")
    public Optional<PositionSiege> parId(@PathVariable Integer id){
        return positionSiegeService.trouverParId(id);
    }
    @PutMapping("/modifier")
    public PositionSiege modif(@RequestBody PositionSiege positionSiege){
        return positionSiegeService.misAJour(positionSiege);
    }

    @DeleteMapping("/supprimer")
    public void supprimer(@PathVariable Integer id){
        positionSiegeService.supprimer(id);
    }

}
