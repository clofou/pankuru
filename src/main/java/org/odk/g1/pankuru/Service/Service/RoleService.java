package org.odk.g1.pankuru.Service.Service;


import lombok.AllArgsConstructor;
import org.odk.g1.pankuru.Entity.Permission.Role;
import org.odk.g1.pankuru.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;


    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(String nom) {
        return roleRepository.findByNom(nom);
    }

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public Role updateRole(String id, Role role) {
        Role roleUpdate = roleRepository.findById(id).orElse(null);
        assert roleUpdate != null;
        roleUpdate.setNom(role.getNom());
        return roleRepository.save(roleUpdate);
    }

    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}

