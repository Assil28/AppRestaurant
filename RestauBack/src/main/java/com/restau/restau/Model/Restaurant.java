package com.restau.restau.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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


    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="Username")
    private Owner owner;


@JsonIgnore
    @OneToMany(mappedBy = "restaurant" ,cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    })
    private Set<Plat> plat;


    public Restaurant() {
    }


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Restaurant(String nom, String adresse, Set<Plat> plats) {
        this.nom = nom;
        Adresse = adresse;
        this.plat = plats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Plat> getPlat() {
        return plat;
    }

    public void setPlat(Set<Plat> plat) {
        this.plat = plat;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
