package org.odk.g1.pankuru.Controller;

// import org.hibernate.mapping.List;
import org.odk.g1.pankuru.Entity.ReservationDeVol.ClasseSiege;
import org.odk.g1.pankuru.Service.Service.ClasseSiegeService;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classe")
public class ClasseSiegeControleur {
   private ClasseSiegeService classeSiegeService;
   @PostMapping("/ajout")
   public ClasseSiege ajouterClasseSiege( ClasseSiege classeSiege) {
    return classeSiegeService.ajout(classeSiege);

}
}


