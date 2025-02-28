package com.example.Event.repositories;

import com.example.Event.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByNom(String nom);
    Optional<Client> findByEmail(String email);
}
