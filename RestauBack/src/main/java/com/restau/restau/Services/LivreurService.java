package com.restau.restau.Services;

import com.restau.restau.Dao.LivreurDao;
import com.restau.restau.Dao.RoleDao;
import com.restau.restau.Model.Livreur;
import com.restau.restau.Model.Restaurant;
import com.restau.restau.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LivreurService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private LivreurDao livreurDao;

    @Autowired
    private RoleDao roleDao;

    public Livreur AjouterLivreur(Livreur livreur)
    {
        Role role = roleDao.findById("livreur").get();
        Set<Role> Roles=new HashSet<>();
        Roles.add(role);
        livreur.setMotpasse(getEncodedPassword(livreur.getMotpasse()));
        livreur.setRole(Roles);
        return  this.livreurDao.save(livreur);
    }

    public Livreur GetLivreurByUsername(String username)
    {
        return this.livreurDao.findById(username).get();
    }

    public List<Livreur> TousLesLivreurs(){
        return (List<Livreur>) this.livreurDao.findAll();
    }

    public Livreur DeleteLivreurById(String username)
    {
        Livreur livreur=this.livreurDao.findById(username).get();
        this.livreurDao.deleteById(username);
        return livreur;
    }


    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
