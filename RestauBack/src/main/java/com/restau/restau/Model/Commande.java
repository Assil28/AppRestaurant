package com.restau.restau.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prix;

@JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User user;
@JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "livreurIf")
    private Livreur livreur;
@JsonIgnore
@OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    })
    @JoinTable(name="Commande_produit",
    joinColumns = {@JoinColumn(name = "id_commande")},
    inverseJoinColumns = {@JoinColumn(name = "id_produit")})
    private List<Produit> produits;
@JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    })
    @JoinTable(name="Commande_plats",
            joinColumns = {@JoinColumn(name = "id_commande")},
            inverseJoinColumns = {@JoinColumn(name = "id_plat")})
    private List<Plat> plats;

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void setPlats(List<Plat> plats) {
        this.plats = plats;
    }


}
