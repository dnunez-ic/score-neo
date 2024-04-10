package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Role;
import com.innerconsulting.scoreneo.model.Score;
import com.innerconsulting.scoreneo.model.Unit;
import com.innerconsulting.scoreneo.repository.RoleRepository;
import com.innerconsulting.scoreneo.repository.ScoreRepository;
import com.innerconsulting.scoreneo.repository.UnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    public Role saveRole( Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(Role role){
        Optional<Role> roleFromDB=roleRepository.findById(role.getId());
        if(roleFromDB.isPresent()){

            Role roleFromDBVal = roleFromDB.get();

            roleFromDBVal.setName(role.getName());
            roleFromDBVal.setProducts(role.getProducts());

            roleRepository.save(roleFromDBVal);
        }else {
            return null;
        }
        return role;
    }


    public Role findRoleById(Long id) {

        return this.roleRepository.findById(id).orElse(null);
    }


    public void deleteRoleById(Long id) {

        this.roleRepository.deleteById(id);
    }
}
