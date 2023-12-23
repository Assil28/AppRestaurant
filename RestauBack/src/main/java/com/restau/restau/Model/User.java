package com.restau.restau.Model;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    private String Username;
    private  String Nom;
    private String Prenom;
    private  String Local;
    private String Email;
    private String Motpasse;

    private double solde=20000;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "User_Role",joinColumns =
            {
                    @JoinColumn(name = "User_Name")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "Role_Name")
            }
    )
    private Set<Role> role;

    @OneToOne(mappedBy = "user",cascade = {
            CascadeType.PERSIST,
            CascadeType.ALL
    })
    private Commande commande;

    public User() {
    }

    public User(String username,String nom, String prenom, String local, String email, String motpasse) {
        Nom = nom;
        Prenom = prenom;
        Local = local;
        Email = email;
        Motpasse = motpasse;
        Username = username;

    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
