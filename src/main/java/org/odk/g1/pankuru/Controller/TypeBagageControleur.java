package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.TypeBagage;
import org.odk.g1.pankuru.Service.Service.TypeBagageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/typeBagage")
public class TypeBagageControleur {
    private TypeBagageService typeBagageService;

    @PostMapping("/ajout")
    public TypeBagage ajouter(@RequestBody TypeBagage typeBagage){
        return typeBagageService.ajout(typeBagage);
    }
    @GetMapping("/liste")
    public List<TypeBagage>lire(){
        return typeBagageService.liste();
    }
    @GetMapping("/liste/{id}")
    public Optional<TypeBagage> parId(@PathVariable Integer id){
        return typeBagageService.trouverParId(id);
    }

    @PutMapping("/modifier")
    public TypeBagage modif(@RequestBody TypeBagage typeBagage){
        return typeBagageService.misAJour(typeBagage);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supp(@PathVariable Integer id){
        typeBagageService.supprimer(id);
    }

}
