package org.odk.g1.pankuru.Controller.HumainController;

import java.util.List;

import org.odk.g1.pankuru.Entity.Humain.Faq;
import org.odk.g1.pankuru.Service.Service.HumainService.FaqService;
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
@RequestMapping("/faq")
@AllArgsConstructor
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
    public Faq modifier(@PathVariable Integer id,@RequestBody Faq faq){
        return faqService.misAJour(faq, id);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable Integer id){
        faqService.supprimer(id);
    }
}
