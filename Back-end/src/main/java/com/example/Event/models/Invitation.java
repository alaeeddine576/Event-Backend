package com.example.Event.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int dateEnvoi;

    private String codeInvitation;

    private String message;

    private LocalDate date_expiration;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="evenment_id")
    private Evenment evenment;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;
}
