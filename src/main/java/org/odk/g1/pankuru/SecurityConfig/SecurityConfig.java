package org.odk.g1.pankuru.SecurityConfig;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    //private final JwtAuth jwtAuth;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request->
                        request
                                .requestMatchers("/superadmin/ajout", "/superadmin/afficher/**","/superadmin/supprimer/**", "/superadmin/modifier/**").permitAll()
                                .requestMatchers("/avion/ajout", "/avion/afficher/**", "/avion/supprimer/**", "/avion/modifier/**").permitAll()
                                .requestMatchers("/vol/ajout", "/vol/modifier/**","/vol/afficher", "/vol/supprimer/**").permitAll()
                                .requestMatchers("/admin/ajout", "/admin/afficher/**","/admin/modifier/**", "/admin/supprimer/**").permitAll()
                                .requestMatchers("/faq/ajout", "/faq/afficher/**", "/faq/modifier/**", "/faq/supprimer/**").permitAll()
                                .requestMatchers("/siege/ajout", "/siege/afficher/**", "/siege/modifier/**", "/siege/supprimer/**").permitAll()
                                .requestMatchers("/personne/ajout", "/personne/afficher/**", "/personne/modifier/**", "/personne/supprimer/**").permitAll()
                                .requestMatchers("/personnel/ajout", "/personnel/afficher/**", "/personnel/modifier/**", "/personnel/supprimer/**").permitAll()
                                .requestMatchers("/aeroport/ajout", "/aeroport/afficher/**", "/aeroport/modifier/**", "/aeroport/supprimer/**").permitAll()
                                .requestMatchers("/compagnie/ajout", "/compagnie/afficher/**", "/compagnie/modifier/**", "/compagnie/supprimer/**").permitAll()
                                .requestMatchers("/role/**").permitAll()
                                .requestMatchers("/personne/connexion").permitAll()
                                .requestMatchers("/passager/modifier/**", "/passager/ajout","/passager/afficher/**", "passager/supprimer/**").permitAll()
                                .requestMatchers("/utilisateur/modifier/**", "/utilisateur/ajout","utilisateur/afficher/**", "utilisateur/supprimer/**").permitAll()
                                .requestMatchers("/reservation/modifier/**", "/reservation/ajout","reservation/afficher/**", "reservation/supprimer/**").permitAll()
                                .requestMatchers("/role/modifier/**", "/role/ajout","role/afficher/**", "role/supprimer/**").permitAll()
                                .requestMatchers("/admincompagnie/modifier/**", "/admincompagnie/ajout","admincompagnie/afficher/**", "admincompagnie/supprimer/**").permitAll()
                                .anyRequest().authenticated())
                .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}