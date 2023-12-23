package com.restau.restau.Model;

public class JwtResponse {

    private User user;
    private Livreur livreur;
    private Owner owner;

    private String jwtToken;

    public JwtResponse(User user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }
    public JwtResponse(Livreur livreur, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }
    public JwtResponse(Owner owner, String jwtToken) {
        this.owner = owner;
        this.jwtToken = jwtToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}

