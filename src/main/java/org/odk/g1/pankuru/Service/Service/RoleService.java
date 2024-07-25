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

    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(int id, Role role) {
        Role roleUpdate = roleRepository.findById(id).orElse(null);
        assert roleUpdate != null;
        roleUpdate.setNom(role.getNom());
        return roleRepository.save(roleUpdate);
    }

    public void deleteRole(int id) {
        Role roleToDelete = roleRepository.findById(id).orElse(null);
        assert roleToDelete != null;
        roleRepository.delete(roleToDelete);
    }
}

