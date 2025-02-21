package com.example.Event.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("organisateur")
public class Organisateur extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String nomentreprise;

    private String adresse;

    private String telephone;

    private String CIN;

    public Integer getId() {
        return id;
    }
}
