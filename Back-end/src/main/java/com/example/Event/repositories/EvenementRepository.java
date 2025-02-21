package com.example.Event.repositories;


import com.example.Event.models.Evenment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenment, Integer> {

}