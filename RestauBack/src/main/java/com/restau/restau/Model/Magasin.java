package com.restau.restau.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
public class Magasin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idm;
    private String nom;
    private String Adresse;

    private Time heureouverte;
    private Time heureferme;

    private double solde;
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    })
    @JoinColumn(name = "image_plat")
    private Image image;
@JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name="Username")
    private Owner owner;
@JsonIgnore
    @OneToMany(mappedBy = "magasin",cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    },fetch = FetchType.EAGER)
    private Set<Produit> produits;


    public Magasin() {
    }

    public Magasin(String nom, String adresse, Time heureouverte, Time heureferme, Owner owner) {
        this.nom = nom;
       this.Adresse = adresse;
        this.heureouverte = heureouverte;
        this.heureferme = heureferme;
        this.owner = owner;
    }

    public long getIdm() {
        return idm;
    }

    public void setIdm(long idm) {
        this.idm = idm;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public long getId() {
        return idm;
    }

    public void setId(long id) {
        this.idm = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Time getHeureouverte() {
        return heureouverte;
    }

    public void setHeureouverte(Time heureouverte) {
        this.heureouverte = heureouverte;
    }

    public Time getHeureferme() {
        return heureferme;
    }

    public void setHeureferme(Time heureferme) {
        this.heureferme = heureferme;
    }

    public Owner getOwner() {
        return owner;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
