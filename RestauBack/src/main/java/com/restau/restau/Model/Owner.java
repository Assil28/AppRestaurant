package com.restau.restau.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

    @Entity
    public class Owner{
        @Id
        private String Username;
        private  String Nom;
        private String Prenom;
        private  String Local;
        private String Email;
        private String Motpasse;

        private double solde;

        @ManyToMany(fetch = FetchType.EAGER)  //one to one
        @JoinTable(name = "Owner_Role",joinColumns =
                {
                        @JoinColumn(name = "Owner_Name")
                },
                inverseJoinColumns = {
                        @JoinColumn(name = "Role_Name")
                }
        )
        private Set<Role> role;


        @JsonIgnore
        @OneToMany(mappedBy="owner" ,cascade = {
                CascadeType.PERSIST,
                CascadeType.ALL
        })
        private Set<Restaurant> restaurant;


        @JsonIgnore
        @OneToMany(mappedBy="owner" ,cascade = {
                CascadeType.PERSIST,
                CascadeType.ALL
        })
        private Set<Magasin> magasins;

        public Owner() {
        }

        public Owner(String nom, String prenom, String local, String email, String motpasse, Set<Role> role, Set<Restaurant> restaurant, Set<Magasin> magasins) {
            Nom = nom;
            Prenom = prenom;
            Local = local;
            Email = email;
            Motpasse = motpasse;
            this.role = role;
            this.restaurant = restaurant;
            this.magasins = magasins;
        }

        public Owner(String username, String nom, String prenom, String local, String email, String motpasse) {
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

        public Set<Restaurant> getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(Set<Restaurant> restaurant) {
            this.restaurant = restaurant;
        }

        public Set<Magasin> getMagasins() {
            return magasins;
        }

        public void setMagasins(Set<Magasin> magasins) {
            this.magasins = magasins;
        }
    }

