package com.restau.restau.Model;


import javax.persistence.*;

@Entity
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String type;

    private Double prix;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    })
    @JoinColumn(name = "image_plat")
    private Image image;



    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="id_restaurant")
    private Restaurant restaurant;

    public Plat(String nom, String type, Double prix, Image image) {
        this.nom = nom;
        this.type = type;
        this.prix = prix;
        this.image = image;
    }

    public Plat() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}
