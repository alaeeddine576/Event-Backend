package com.example.Event.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@Builder
@Entity
@DiscriminatorColumn(name ="role")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    private String Password;

    private byte[] ProfileImage;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Invitation> invitations;


    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Ticket> tickets;



    public User(String login, String password, byte[] profileImage,List<Invitation> invitations, List<Ticket> tickets) {

        this.invitations = invitations;
        this.login = login;
        this.Password = password;
        this.ProfileImage = profileImage;
        this.tickets = tickets;
    }

    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public byte[] getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        ProfileImage = profileImage;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
