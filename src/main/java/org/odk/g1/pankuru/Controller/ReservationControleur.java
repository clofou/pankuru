package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
// import org.odk.g1.pankuru.Entity.ReservationDeVol.Passager;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Service.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationControleur {
    private ReservationService reservationService;
    @PostMapping("/ajout")
    public Reservation ajouter(@RequestBody Reservation reservation){
        return reservationService.ajout(reservation);
    }

    @GetMapping("/afficher")
    public List<Map<String, Object>> lire(){
        return reservationService.liste1();
    }

    @GetMapping("/afficher/{id}")
    public List<Map<String, Object>> parId(@PathVariable Long id){
        return reservationService.trouverParId1(id);
    }

    @PutMapping("/modifier/{id}")
    public Reservation modif(@PathVariable Long id,@RequestBody Reservation reservation){
        return reservationService.misAJour(reservation, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supp(@PathVariable Long id){
        reservationService.supprimer(id);
    }

}
