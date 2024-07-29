package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.SuperAdmin;
import org.odk.g1.pankuru.Service.Service.HumainService.SuperAdminService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/superadmin")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class SuperAdminController {
    
    private final SuperAdminService superAdminService;

    @PostMapping("/ajout")
    public SuperAdmin ajouter(@RequestBody SuperAdmin superAdmin){
        return superAdminService.ajout(superAdmin);
    }

    @GetMapping("/afficher")
    public List<SuperAdmin> afficher(){
        return superAdminService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public SuperAdmin modifier(@RequestBody SuperAdmin superAdmin){
        return superAdminService.misAJour(superAdmin);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        superAdminService.supprimer(id);
    }
}
