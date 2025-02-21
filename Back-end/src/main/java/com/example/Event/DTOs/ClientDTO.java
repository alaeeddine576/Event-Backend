package com.example.Event.DTOs;

public class ClientDTO {
    private String nom;
    private String prenom;
    private String email;
    private Integer telephone;
    private String password;

    public String getPassword() {
        return password;
    }

    public ClientDTO(String nom, String prenom, String email, Integer telephone, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Integer getTelephone() {
        return telephone;
    }


}
