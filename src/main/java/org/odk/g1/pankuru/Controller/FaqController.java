package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Compagnie.Faq;
import org.odk.g1.pankuru.Service.Service.FaqService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faq")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class FaqController {
    private final FaqService faqService;

    @PostMapping("/ajout")
    public Faq ajouter(@RequestBody Faq faq){
        return faqService.ajout(faq);
    }

    @GetMapping("/afficher")
    public List<Faq> afficher(){
        return faqService.liste();
    }

    @PutMapping("/modifier/{id}")
    public Faq modifier(@RequestBody Faq faq){
        return faqService.misAJour(faq);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Long id){
        faqService.supprimer(id);
    }
}