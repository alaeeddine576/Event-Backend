package com.example.Event.DTOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EvenmentDTO {

    private String nomEvenement;

    private LocalDateTime date_debut;

    private LocalDate date_fin_inscription;

    private String description;

    private String localisation;

    private Integer prix;

    private int nbPlacesDisponibles;

    private byte[] image;

    private String contact;

    private String email;


    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin_inscription() {
        return date_fin_inscription;
    }

    public void setDate_fin_inscription(LocalDate date_fin_inscription) {
        this.date_fin_inscription = date_fin_inscription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public int getNbPlacesDisponibles() {
        return nbPlacesDisponibles;
    }

    public void setNbPlacesDisponibles(int nbPlacesDisponibles) {
        this.nbPlacesDisponibles = nbPlacesDisponibles;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
