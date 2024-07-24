package org.odk.g1.pankuru.Controller;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Bagage;
import org.odk.g1.pankuru.Service.Service.BagageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bagage")
public class BagageControleur {
    private BagageService bagageService;
    @PostMapping("/ajout")
    public Bagage ajoutBagage( Bagage bagage){
        return bagageService.ajout(bagage);
    }
    @GetMapping("/Liste")
    public List<Bagage> ListBagage(){
        return bagageService.liste();
    }
    @GetMapping("/Liste/{id}")
    public Optional<Bagage> listParId(@PathVariable Long id){
        return bagageService.trouverParId(id);
    }
    @PutMapping("/modifier")
    public Bagage modif(Bagage bagage){
        return bagageService.misAJour(bagage);
    }

    @DeleteMapping("/supprimer/{id}")
    public void suppriBagage(Long id){
        bagageService.supprimer(id);
    }

}
