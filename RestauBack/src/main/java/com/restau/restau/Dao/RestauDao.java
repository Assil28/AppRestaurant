package com.restau.restau.Dao;


import com.restau.restau.Model.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RestauDao extends JpaRepository<Restaurant,Long> {
}
