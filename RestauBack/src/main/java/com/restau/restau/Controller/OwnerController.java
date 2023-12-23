package com.restau.restau.Controller;

import com.restau.restau.Model.*;
import com.restau.restau.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@CrossOrigin("http://localhost:4200")
@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/AddOwner")
    public Owner enregstrerOwner(@RequestBody Owner owner){
        return  this.ownerService.enregstrerOwner(owner);
    }


    @PostMapping("/AddRestaurant/{ownername}")
    public Restaurant enregestrerrestau(@RequestBody Restaurant restaurant,@PathVariable String ownername){
        return  this.ownerService.enregestrerRestau(restaurant,ownername);
    }

    @GetMapping("/FindOwnerById/{Username}")
    public Owner FindOwnerById(@PathVariable String Username){
        return this.ownerService.FindOwnerById(Username);
    }

    @PostMapping("/AddMagasin/{username}")
    public Magasin enregestrerMagasin(@RequestBody Magasin magasin,@PathVariable String username){
        return this.ownerService.enregestrerMagasin(magasin,username);
    }

    @PostMapping("/AddPlat")
    public Plat enregistrerPlat(@RequestBody Plat plat){
        return this.ownerService.enregistrerPlat(plat);

    }

    @PostMapping("/addProduit")
    public Produit enregistrerProduit(@RequestBody Produit produit){
       return this.ownerService.enregistrerProduit(produit);
    }

    @PostMapping("/DeleteOwnner/{username}")
    public Owner DeleteOwner(@PathVariable String username)
    {
        return this.ownerService.DeleteOwner(username);
    }

    @PostMapping("/DeleteRestaurant/{id}")
    public Restaurant DeleteRestaurantById(@PathVariable Long id)
    {
        return this.ownerService.DeleteRestaurantById(id);
    }

    @PostMapping("/DeleteMagasin/{id}")
    public Magasin DeleteMagasinById(@PathVariable Long id)
    {
        return this.ownerService.DeleteMagasinById(id);
    }


    @PostMapping("/DeletePlat/{id}")
    public Plat DeletePlatById(@PathVariable Long id)
    {
        return this.ownerService.DeletePlatById(id);
    }

    @PostMapping("/DeleteProduit/{id}")
    public Produit DeleteProduitById(@PathVariable Long id)
    {
        return this.ownerService.DeleteProduitById(id);
    }

    @GetMapping("/TouslesMagasin")
    public List<Magasin> TouslesMagasin()
    {
        return this.ownerService.TouslesMagasin();
    }

    @GetMapping("/TouslesRestaurant")
    public List<Restaurant> TouslesRestaurant()
    {
        return this.ownerService.TouslesRestaurant();
    }

    @GetMapping("/TouslesProduit/{idm}")
    public Set<Produit> TouslesProduit(@PathVariable Long idm)
    {
        return this.ownerService.TouslesProduit(idm);
    }

    @GetMapping("/TouslesPlat/{idr}")
    public Set<Plat> TouslesPlat(@PathVariable Long idr)
    {
        return this.ownerService.TouslesPlat(idr);
    }

    @GetMapping("/MagasinById/{idm}")
    public Magasin MagasinById(@PathVariable Long idm)
    {
        return this.ownerService.MagasinById(idm);
    }

    @GetMapping("/RestaurantById/{idr}")
    public Restaurant RestaurantById(@PathVariable Long idr)
    {
        return this.ownerService.RestaurantById(idr);
    }

    @GetMapping("/RestaurantOwner/{username}")
    public Set<Restaurant> GetAllRestaurantOwner(@PathVariable String username)
    {
        return this.ownerService.GetAllRestaurantOwner(username);
    }

    @GetMapping("/MagasinOwner/{username}")
    public Set<Magasin> GetAllMagasinOwner(@PathVariable String username)
    {
        return this.ownerService.GetAllMagasinOwner(username);
    }
}
