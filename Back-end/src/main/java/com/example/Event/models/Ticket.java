package com.example.Event.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateAchat;

    private int montantPaiement;

    private String statut; //(valide, utilisé, annulé)

    private int nbPlaces;

    private double prixTotal;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="evenment_id")
    private Evenment evenment;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name ="user_id")
    private User user;

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(int montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

}
