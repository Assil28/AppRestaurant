package com.restau.restau.Services;

import com.restau.restau.Dao.RoleDao;
import com.restau.restau.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role AddRole(Role role){
        return roleDao.save(role);
    }
}
