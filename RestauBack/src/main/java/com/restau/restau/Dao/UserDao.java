package com.restau.restau.Dao;

import com.restau.restau.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,String> {
}
