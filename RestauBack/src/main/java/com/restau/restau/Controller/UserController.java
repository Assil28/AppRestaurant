package com.restau.restau.Controller;

import com.restau.restau.Dao.LivreurDao;
import com.restau.restau.Model.Commande;
import com.restau.restau.Model.Livreur;
import com.restau.restau.Model.Produit;
import com.restau.restau.Model.User;
import com.restau.restau.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LivreurDao livreurDao;
    @PostConstruct
    public void init(){
        userService.init();
    }
    @PostMapping("/RegistreUser")
    public User RegistreNewUser(@RequestBody User user){
        return userService.RegistreNewUser(user);
    }
    @PostMapping("/AcheterProduit/{idUser}/{idP}")
    public Commande acheterProduit(@PathVariable Long idP, @PathVariable String idUser) {
    return  this.userService.acheterProduit(idP,idUser);
    }
    @GetMapping("/getliv/{id}")
    public Set<Commande> getliv(@PathVariable String id){
        Livreur livreur=this.livreurDao.findById(id).get();
        return livreur.getCommande();
    }

    @PostMapping("/valideC/{idc}")
    public Commande validercomande(@PathVariable Long idc)
    {
        return this.userService.validercomande(idc);
    }


}
