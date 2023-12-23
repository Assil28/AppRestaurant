package com.restau.restau.Dao;

import com.restau.restau.Model.Role;
import com.restau.restau.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao  extends CrudRepository<Role,String> {
}
