package org.odk.g1.pankuru.Controller;

import org.odk.g1.pankuru.Entity.ReservationDeVol.Bagage;
import org.odk.g1.pankuru.Service.Service.BagageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Bagage>listParId(@PathVariable Integer id){
        return null;
    }

}
