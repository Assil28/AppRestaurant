package com.restau.restau.Dao;

import com.restau.restau.Model.Commande;
import org.springframework.data.repository.CrudRepository;

public interface CommandeDao extends CrudRepository<Commande,Long> {
}
