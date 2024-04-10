package com.innerconsulting.scoreneo.controller;

import com.innerconsulting.scoreneo.model.Role;
import com.innerconsulting.scoreneo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/")
    public List<Role> getAllRole(){
        return roleService.getAllRole();
    }

    @PostMapping("")
    public Role addAuthor(@RequestBody Role role){

        return roleService.saveRole(role);

    }

    @PutMapping("")
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping("/role/{roleId}")
    public void deleteRole(@PathVariable Long roleId){
        roleService.deleteRoleById(roleId);
    }

}

