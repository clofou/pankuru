package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Vol;
import org.odk.g1.pankuru.Service.Service.VolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("vol")
public class VolControleur {
    private VolService volService;
    @PostMapping("/ajout")
    public Vol ajout(@RequestBody Vol vol){
        return volService.ajout(vol);
    }
    @GetMapping("/liste")
    public List<Vol>lire(){
        return volService.liste();
    }

    @GetMapping("/liste/{id}")
    public Optional<Vol> parId(@PathVariable Long id){
        return volService.trouverParId(id);
    }

    @PutMapping("/modifier")
   public Vol modif(@RequestBody Vol vol){
        return volService.misAJour(vol);
    }

    @DeleteMapping("/supprimer")
    public void supp(@PathVariable Long id){
        volService.supprimer(id);

    }
}
