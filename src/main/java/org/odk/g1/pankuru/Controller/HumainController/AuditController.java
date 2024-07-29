package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Audit;
import org.odk.g1.pankuru.Service.Service.HumainService.AuditService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/audit")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class AuditController {
    private final AuditService auditService;

    @PostMapping("/ajout")
    public Audit ajouter(@RequestBody Audit audit){
        return auditService.ajout(audit);
    }

    @GetMapping("/afficher")
    public List<Audit> afficher(){
        return auditService.liste();
    } 

    @PutMapping("/modifier/{id}")
    public Audit modifier(@PathVariable Long id,@RequestBody Audit audit){
        return auditService.misAJour(audit, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        auditService.supprimer(id);
    }
}
