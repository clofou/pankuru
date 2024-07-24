package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Audit;
import org.odk.g1.pankuru.Service.Service.HumainService.AuditService;
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
@RequestMapping("/audit")
@AllArgsConstructor
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
    public Audit modifier(@RequestBody Audit audit){
        return auditService.misAJour(audit);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        auditService.supprimer(id);
    }
}
