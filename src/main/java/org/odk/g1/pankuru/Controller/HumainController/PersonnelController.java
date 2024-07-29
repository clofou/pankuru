package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Personnel;
import org.odk.g1.pankuru.Service.Service.HumainService.PersonnelService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/personnel")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class PersonnelController {
    
    private final PersonnelService personnelService;

    @PostMapping("/ajout")
    public Personnel ajouter(@RequestBody Personnel personnel){
        return personnelService.ajout(personnel);
    }

    @GetMapping("/afficher")
    public List<Personnel> afficher(){
        return personnelService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Personnel modifier(@PathVariable Long id,@RequestBody Personnel personnel){
        return personnelService.misAJour(personnel, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        personnelService.supprimer(id);
    }
}
