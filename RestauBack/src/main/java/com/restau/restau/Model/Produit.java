package com.restau.restau.Model;


import javax.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    private Double prix;


    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    })
    @JoinColumn(name = "image_produit")
    private Image image;




    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="id_magasin")
    private Magasin magasin;


    public Produit(String nom, Double prix, Image image) {
        this.nom = nom;
        this.prix = prix;
        this.image = image;
    }

    public Produit(String nom, Image image) {
        this.nom = nom;

        this.image = image;
    }

    public Produit() {
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

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
}
