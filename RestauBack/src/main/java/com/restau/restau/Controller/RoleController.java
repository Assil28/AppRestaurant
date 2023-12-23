package com.restau.restau.Controller;




import com.restau.restau.Model.Role;
import com.restau.restau.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/AddRole")
    public Role RegistreNewRole(@RequestBody Role role){ return roleService.AddRole(role);}

}

