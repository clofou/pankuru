package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Service.Service.HumainService.UtilisateurService;
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
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurController {
    
    private final UtilisateurService utilisateurService;

    @PostMapping("/ajout")
    public Utilisateur ajouter(@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajout(utilisateur);
    }

    @GetMapping("/afficher")
    public List<Utilisateur> afficher(){
        return utilisateurService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Utilisateur modifier(@PathVariable Long id,@RequestBody Utilisateur utilisateur){
        return utilisateurService.misAJour(utilisateur, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        utilisateurService.supprimer(id);
    }
}
