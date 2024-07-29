package org.odk.g1.pankuru.Controller;

import java.util.List;

import org.odk.g1.pankuru.Entity.Localite.Pays;
import org.odk.g1.pankuru.Service.Service.PaysService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pays")
@AllArgsConstructor
public class PaysController {
    
    private final PaysService paysService;

    @PostMapping("/ajout")
    public Pays ajouter(@RequestBody Pays pays){
        return paysService.ajout(pays);
    }

    @GetMapping("/afficher")
    public List<Pays> afficher(){
        return paysService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Pays modifier(@PathVariable Integer id,@RequestBody Pays pays){
        return paysService.misAJour(pays, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        paysService.supprimer(id);
    }
}
