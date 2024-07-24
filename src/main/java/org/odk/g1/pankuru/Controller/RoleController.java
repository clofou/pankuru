package org.odk.g1.pankuru.Controller;

import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Permission.Role;
import org.odk.g1.pankuru.Service.Service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List getAllRole(){
        return roleService.getAllRole();
    }

    @GetMapping("/{id}")
    public  Optional<Role> getRoleById(@PathVariable("id") Integer id) {
     return this.roleService.getRoleById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void ajouteRole(@RequestBody Role role){
        this.roleService.createRole(role);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public Role modifierRole(@PathVariable("id") int id, @RequestBody  Role role){
        return this.roleService.updateRole(id, role);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void supprimerRole(@PathVariable("id") Integer id){
        this.roleService.deleteRole(id);
    }



}
