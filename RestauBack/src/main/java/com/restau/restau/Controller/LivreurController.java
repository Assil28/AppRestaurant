package com.restau.restau.Controller;


import com.restau.restau.Model.Livreur;
import com.restau.restau.Model.User;
import com.restau.restau.Services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class LivreurController {

    @Autowired
    private LivreurService livreurService;

    @PostMapping("/RegistreLivreur")
    public Livreur AjouterLivreur(@RequestBody Livreur livreur){
        return livreurService.AjouterLivreur(livreur);
    }
}
