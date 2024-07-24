package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Passager;
import org.odk.g1.pankuru.Entity.ReservationDeVol.Reservation;
import org.odk.g1.pankuru.Service.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationControleur {
    private ReservationService reservationService;
    @PostMapping("/reservation")
    public Reservation ajouter(Reservation reservation){
        return reservationService.ajout(reservation);
    }

    @GetMapping("/Liste")
    public List<Reservation> lire(){
        return reservationService.liste();
    }

    @GetMapping("/liste/{id}")
    public Optional<Reservation> parId(@PathVariable Long id){
        return reservationService.trouverParId(id);
    }

    @PutMapping("/modifier")
    public Reservation modif(@RequestBody Reservation reservation){
        return reservationService.misAJour(reservation);
    }

    @DeleteMapping("/supprimer")
    public void supp(@PathVariable Long id){
        reservationService.supprimer(id);
    }

}
