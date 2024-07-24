package org.odk.g1.pankuru.Controller.HumainController;

import org.odk.g1.pankuru.Entity.Humain.Personne;
import org.odk.g1.pankuru.Repository.HumainRepo.PersonneRepo;
import org.odk.g1.pankuru.Service.Service.HumainService.PersonneService;
import org.odk.g1.pankuru.Service.Service.JwtService;
import org.odk.g1.pankuru.dto.AuthentificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/personne")
@AllArgsConstructor
public class PersonneController {

    private final PersonneService personneService;
    private final AuthenticationManager authenticationManager;
    private final PersonneRepo personneRepo;
    private JwtService jwtService;

//    @PostMapping("/se-connecter")
//    public Personne seConnecter(@RequestBody Personne personne) {
//        return personneService.seConnecter(personne.getEmail(), personne.getPassword());
//
//    }

    @PostMapping(path = "connexion")
    public ResponseEntity<AuthentificationDTO> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        try {
            final Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authentificationDTO.getUsername(), authentificationDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            UserDetails userDetails = (UserDetails) authenticate.getPrincipal();

            Personne user = (Personne) userDetails;

            AuthentificationDTO response = new AuthentificationDTO();
            response.setUsername(userDetails.getUsername());
            response.setNom(user.getNom());

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            response.setRole(roles);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(null);
        }
    }
}
