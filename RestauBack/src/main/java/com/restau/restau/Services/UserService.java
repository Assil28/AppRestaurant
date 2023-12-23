package com.restau.restau.Services;

import com.restau.restau.Dao.*;
import com.restau.restau.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProduitDao produitDao;
    @Autowired
    private LivreurDao livreurDao;

    @Autowired
    private MagasinDao magasinDao;

    @Autowired
    private RestauDao restauDao;
@Autowired
private CommandeDao commandeDao;

    public User RegistreNewUser(User user)
    {
        Role role = roleDao.findById("client").get();
        Set<Role> Roles=new HashSet<>();
        Roles.add(role);
        user.setMotpasse(getEncodedPassword(user.getMotpasse()));
        user.setRole(Roles);
        userDao.save(user);
        return user;
    }

    public User DeleteUserById(String username)
    {
        User user=this.userDao.findById(username).get();
        this.userDao.deleteById(username);
        return user;
    }
    public void init(){
        Role role=new Role();
        role.setNom("client");
        role.setDescription("role for client");
        roleDao.save(role);


    }
    public Commande acheterProduit(Long idP,String idUser) {
        List<Livreur> livreurs= (List<Livreur>) this.livreurDao.findAll();
        int il = ThreadLocalRandom.current().nextInt(0, livreurs.size() );
        Produit produit = this.produitDao.findById(idP).get();
        User user = this.userDao.findById(idUser).get();
        if (user.getCommande() == null) {
            Commande commande = new Commande();
            commande.setUser(user);
            List<Produit> produits = new ArrayList<>();
            produits.add(produit);
            int s=0;
            for(int i=0;i<produits.size();i++){
                s+=produits.get(i).getPrix();
            }
            commande.setLivreur(livreurs.get(il));
            commande.setPrix(s);
            commande.setProduits(produits);
            user.setCommande(commande);
            this.commandeDao.save(commande);
            this.userDao.save(user);


            return commande;
        }
        Commande commande=user.getCommande();
        List<Produit> produits =commande.getProduits();
        produits.add(produit);
        int s=0;
        for(int i=0;i<produits.size();i++){
            s+=produits.get(i).getPrix();
        }
        commande.setPrix(s);
        commande.setProduits(produits);
        user.setCommande(commande);
        this.userDao.save(user);
        return commande;
    }
    public Commande validercomande(Long idc){
        Commande commande=this.commandeDao.findById(idc).get();
        List<Livreur> livreurs= (List<Livreur>) this.livreurDao.findAll();
        int il = ThreadLocalRandom.current().nextInt(0, livreurs.size() );
        commande.setLivreur(livreurs.get(il));

        User user=userDao.findById(commande.getUser().getUsername()).get();
        user.setSolde(user.getSolde()-commande.getPrix()+7);

        List<Produit> p=user.getCommande().getProduits();
        for(int i=0;i<p.size();i++)
        {
            p.get(i).getMagasin().setSolde(p.get(i).getMagasin().getSolde()+p.get(i).getPrix());
            this.magasinDao.save(p.get(i).getMagasin());
        }
        List<Plat> pl=user.getCommande().getPlats();
        for(int j=0;j<pl.size();j++)
        {
            pl.get(j).getRestaurant().setSolde(pl.get(j).getRestaurant().getSolde()+pl.get(j).getPrix());
            this.restauDao.save(pl.get(j).getRestaurant());
        }

        commande.getLivreur().setSolde(commande.getLivreur().getSolde()+7);
        livreurDao.save(commande.getLivreur());

        return commande;
    }
    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }


}
