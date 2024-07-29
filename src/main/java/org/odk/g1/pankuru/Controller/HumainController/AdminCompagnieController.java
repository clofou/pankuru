package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.AdminCompagnie;
import org.odk.g1.pankuru.Service.Service.HumainService.AdminCompagnieService;
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
@RequestMapping("/admincompagnie")
@AllArgsConstructor
public class AdminCompagnieController {
    private final AdminCompagnieService adminCompagnieService;

    @PostMapping("/ajout")
    public AdminCompagnie ajouter(@RequestBody AdminCompagnie adminCompagnie){
        return adminCompagnieService.ajout(adminCompagnie);
    }

    @GetMapping("/afficher")
    public List<AdminCompagnie> afficher(){
        return adminCompagnieService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public AdminCompagnie modifier(@PathVariable Long id,@RequestBody AdminCompagnie adminCompagnie){
        return adminCompagnieService.misAJour(adminCompagnie, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        adminCompagnieService.supprimer(id);
    }
    
}
