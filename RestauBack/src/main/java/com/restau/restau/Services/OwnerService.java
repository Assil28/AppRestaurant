package com.restau.restau.Services;
import com.restau.restau.Dao.*;
import com.restau.restau.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OwnerService {
@Autowired
private OwnerDao ownerDao;
@Autowired
private RoleDao roleDao;

@Autowired
private RestauDao restauDao;
@Autowired
private PlatDao platDao;

@Autowired
private MagasinDao magasinDao;
@Autowired
private ProduitDao produitDao;
@Autowired
private PasswordEncoder passwordEncoder;


    public Owner enregstrerOwner(Owner owner){
        Role role = roleDao.findById("owner").get();
        Set<Role> Roles=new HashSet<>();
        Roles.add(role);
        owner.setMotpasse(getEncodedPassword(owner.getMotpasse()));
        owner.setRole(Roles);
        return this.ownerDao.save(owner);
    }

    public Owner DeleteOwner(String username)
    {
        Owner owner=this.ownerDao.findById(username).get();
        this.ownerDao.deleteById(username);
        return owner;
    }

    public Owner FindOwnerById(String Username)
    {
        return this.ownerDao.findById(Username).get();
    }

public Restaurant enregestrerRestau(Restaurant restaurant,String ownername){
        Owner owner=this.ownerDao.findById(ownername).get();
        restaurant.setOwner(owner);
        return this.restauDao.save(restaurant);
}

public Restaurant DeleteRestaurantById(Long id)
{
    Restaurant restaurant=this.restauDao.findById(id).get();
    this.restauDao.deleteById(id);
    return restaurant;
}

    public Magasin enregestrerMagasin(Magasin magasin,String username){

        Owner owner=this.ownerDao.findById(username).get();
        magasin.setOwner(owner);
        return this.magasinDao.save(magasin);
    }

    public List<Magasin> TouslesMagasin()
    {
        return this.magasinDao.findAll();
    }

    public List<Restaurant> TouslesRestaurant()
    {
        return this.restauDao.findAll();
    }

    public Set<Produit> TouslesProduit(Long idm)
    {
        Magasin magasin=this.magasinDao.findById(idm).get();
        return magasin.getProduits();
    }

    public Set<Plat> TouslesPlat(Long idr)
    {
        Restaurant restaurant=this.restauDao.findById(idr).get();
        return restaurant.getPlat();
    }

    public Magasin DeleteMagasinById(Long id)
    {
        Magasin magasin=this.magasinDao.findById(id).get();
        this.magasinDao.deleteById(id);
        return magasin;
    }

    public Magasin MagasinById(Long idm)
    {
        return this.magasinDao.findById(idm).get();
    }

    public Restaurant RestaurantById(Long idr)
    {
        return this.restauDao.findById(idr).get();
    }





    public Plat enregistrerPlat(Plat plat)
    {
        Plat plat1=new Plat();
        plat1=plat;
        return this.platDao.save(plat1);
    }

    public Plat DeletePlatById(Long id)
    {
        Plat plat=this.platDao.findById(id).get();
        this.platDao.deleteById(id);
        return plat;
    }

    public Produit enregistrerProduit(Produit produit)
    {
        Produit produit1=new Produit();
        produit1=produit;
         this.produitDao.save(produit1);
         return produit1;
    }

    public Produit DeleteProduitById(Long id)
    {
        Produit produit=this.produitDao.findById(id).get();
        this.produitDao.deleteById(id);
        return produit;
    }

    public Set<Magasin> GetAllMagasinOwner(String username)
    {
        Owner owner=this.ownerDao.findById(username).get();
        return owner.getMagasins();
    }

    public Set<Restaurant> GetAllRestaurantOwner(String username)
    {
        Owner owner=this.ownerDao.findById(username).get();
        return owner.getRestaurant();
    }




    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
