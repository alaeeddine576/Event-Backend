package com.example.Event.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
//@SuperBuilder
@Entity
@DiscriminatorValue("client")

public class Client extends User {


    private String nom;

    private String prenom;

    private String email;

    private String adresse;

    private Integer telephone;

    private LocalDate date_naissance;

    @Builder(builderMethodName = "ClientBuilder")
    public Client(String login, String Password, byte[] ProfileImage, List<Invitation> invitations, List<Ticket> tickets, List<Evenment> evenments, String adresse, LocalDate date_naissance, String email, String nom, String prenom, Integer telephone) {
        super(login, Password, ProfileImage, invitations, tickets);
        this.adresse = adresse;
        this.date_naissance = date_naissance;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public Client() {
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public String getEmail() {
        return email;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }
}
