package com.example.Event.repositories;

import com.example.Event.models.Organisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrganisateurRepository extends JpaRepository<Organisateur, Integer> {

    Optional<Organisateur> findByEmail(String email);


    }
