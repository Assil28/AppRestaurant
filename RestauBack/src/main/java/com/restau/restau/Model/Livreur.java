package com.restau.restau.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Livreur {
    @Id
    private String Username;

    private  String Nom;
    private String Prenom;
    private  String Local;
    private String Email;
    private String Motpasse;

    private double solde;

    @OneToMany(mappedBy = "livreur",cascade = CascadeType.MERGE)
    private Set<Commande> commande;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "Livreur_Role",joinColumns =
            {
                    @JoinColumn(name = "Livreur_Name")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Role_Name")
            }
    )
    private Set<Role> role;



    public Livreur() {
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Livreur(String username, String nom, String prenom, String local, String email, String motpasse) {
        Username = username;
        Nom = nom;
        Prenom = prenom;
        Local = local;
        Email = email;
        Motpasse = motpasse;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Commande> getCommande() {
        return commande;
    }


    public void setCommande(Set<Commande> commande) {
        this.commande = commande;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMotpasse() {
        return Motpasse;
    }

    public void setMotpasse(String motpasse) {
        Motpasse = motpasse;
    }


}
