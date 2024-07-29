package org.odk.g1.pankuru.Controller.HumainController;

import org.odk.g1.pankuru.Entity.Humain.Personne;
// import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
// import org.odk.g1.pankuru.Service.Service.HumainService.PersonneService;
// import org.odk.g1.pankuru.Service.Service.JwtService;
import org.odk.g1.pankuru.Service.Service.HumainService.PersonneService;
import org.odk.g1.pankuru.dto.AuthentificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personne")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")

public class PersonneController {
    private final PersonneService personneService;
    private final AuthenticationManager authenticationManager;

    /*

        // private final PersonneService personneService;
        private final AuthenticationManager authenticationManager;
        // private final PersonneRepo personneRepo;
        // private JwtService jwtService;

    //    @PostMapping("/se-connecter")
    //    public Personne seConnecter(@RequestBody Personne personne) {
    //        return personneService.seConnecter(personne.getEmail(), personne.getPassword());
    //
    //    }
    */
    @PostMapping(path = "connexion")
    public ResponseEntity<HashMap<String, Object>> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        String email = authentificationDTO.getUsername();
        String password = authentificationDTO.getPassword();
        try {
            final Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authentificationDTO.getUsername(), authentificationDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            UserDetails userDetails = (UserDetails) authenticate.getPrincipal();

            String token = personneService.generateToken((Personne) userDetails);
            String sessionId = personneService.generateSessionId();

            AuthentificationDTO auth = new AuthentificationDTO();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            auth.setRole(roles);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("token", token);
            response.put("username", authentificationDTO.getUsername());
            response.put("Nom", ((Personne) userDetails).getNom());
            response.put("Prenom", ((Personne) userDetails).getPrenom());
            response.put("email", ((Personne) userDetails).getEmail());
            response.put("role", roles);
            response.put("session", sessionId);
            response.put("id", ((Personne) userDetails).getId());

         /* Personne user = (Personne) userDetails;


            response.setUsername(userDetails.getUsername());
            response.setNom(user.getNom());*/



            return ResponseEntity.ok((HashMap<String, Object>) response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(null);
        }
    }

}
