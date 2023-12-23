package com.restau.restau.Dao;

import com.restau.restau.Model.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LivreurDao extends CrudRepository<Livreur,String> {
}
