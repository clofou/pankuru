package org.odk.g1.pankuru.SecurityConfig;

import lombok.AllArgsConstructor;

import org.odk.g1.pankuru.Entity.Enum.EnumPermission;
import org.odk.g1.pankuru.Service.Service.PermissionService;
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
import java.util.List;
import org.odk.g1.pankuru.dto.RolePermissionDTO;
import org.odk.g1.pankuru.Service.Service.RolePermissionService;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RolePermissionService rolePermissionService;
    //private final JwtAuth jwtAuth;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        List<RolePermissionDTO> rolePermissions = rolePermissionService.getAllRolePermissions();

        http.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request->
                    {
                        for (RolePermissionDTO rolePermission : rolePermissions) {
                            if (rolePermission.getPermissionPermission() == EnumPermission.AFFICHER){
                                request.requestMatchers("/"+rolePermission.getPermissionEndpoint()+"/afficher/**").hasRole(rolePermission.getRoleName());
                            }else if (rolePermission.getPermissionPermission() == EnumPermission.AJOUT){
                                request.requestMatchers("/"+rolePermission.getPermissionEndpoint()+"/ajout").hasRole(rolePermission.getRoleName());
                            }else if (rolePermission.getPermissionPermission() == EnumPermission.MODIFIER){
                                request.requestMatchers("/"+rolePermission.getPermissionEndpoint()+"/modifier/*+").hasRole(rolePermission.getRoleName());
                            }else if (rolePermission.getPermissionPermission() == EnumPermission.SUPPRIMER){
                                request.requestMatchers("/"+rolePermission.getPermissionEndpoint()+"/supprimer/*+").hasRole(rolePermission.getRoleName());
                            }
                        }
                        request.anyRequest().authenticated();

                    })
                .sessionManagement(manager->manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.httpBasic(Customizer.withDefaults()).build();
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
