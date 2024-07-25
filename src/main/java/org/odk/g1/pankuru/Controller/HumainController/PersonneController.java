package org.odk.g1.pankuru.Controller.HumainController;

import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Service.Service.HumainService.PersonneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/personne")
@AllArgsConstructor
public class PersonneController {
    
    private final PersonneService personneService;

    @PostMapping("/se-connecter")
    public Personne seConnecter(@RequestBody Personne personne) {
        return personneService.seConnecter(personne.getEmail(), personne.getMotDePasse());
        
    }
}
