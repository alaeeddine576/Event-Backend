package com.example.Event.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.Event.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;




@Entity
public class Evenment {


    public Evenment(){

    }
    public Evenment(byte[] image, List<Invitation> invitations, String title, String localisation, Status status, LocalDate eventDate, Integer price, List<Ticket> tickets) {
        this.image = image;
        this.invitations = invitations;
        this.title = title;
        this.localisation = localisation;
        this.status = status;
        this.eventDate = eventDate;
        this.price = price;
        this.tickets = tickets;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Lob
    private byte[] image ;

    private String title ;

    private  String localisation ;

    private LocalDate eventDate ;

    private Integer price ;

    private Status status ;

        @OneToMany(
            mappedBy = "evenment"
    )
    @JsonManagedReference
    private List<Ticket> tickets;

    @OneToMany(
            mappedBy = "evenment"
    )
    @JsonManagedReference
    private List<Invitation> invitations;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }
}