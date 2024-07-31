package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;
import java.util.Map;

import org.odk.g1.pankuru.Entity.Humain.Utilisateur;
import org.odk.g1.pankuru.Service.Service.HumainService.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class UtilisateurController {
    
    private final UtilisateurService utilisateurService;

    @PostMapping("/ajout")
    public Utilisateur ajouter(@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajout(utilisateur);
    }

    @GetMapping("/afficher")
    public List<Map<String, Object>> afficher(){
        return utilisateurService.liste1();
    }

    @GetMapping("/afficher/{id}")
    public List<Map<String, Object>> afficherId(@PathVariable Long id){
        return utilisateurService.trouverParId1(id);
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
