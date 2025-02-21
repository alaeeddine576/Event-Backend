package com.example.Event.services;

import com.example.Event.models.Organisateur;
import com.example.Event.repositories.OrganisateurRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrganisateurService {

    @Autowired
    private final OrganisateurRepository organisateurRepository;

    public OrganisateurService(OrganisateurRepository organisateurRepository) {
        this.organisateurRepository = organisateurRepository;
    }

    public Organisateur saveOrganisateur(Organisateur organisateur) {
        return organisateurRepository.save(organisateur);
    }

    public List<Organisateur> getAllOrganisateurs() {
        return organisateurRepository.findAll();
    }


    public Optional<Organisateur> getOrganisateurById(Integer id) {
        return organisateurRepository.findById(id);
    }

    public Organisateur updateOrganisateur(Organisateur organisateur) {
        if (organisateurRepository.existsById(organisateur.getId())) {
            return organisateurRepository.save(organisateur);
        }
        throw new RuntimeException("Organisateur not found with id: " + organisateur.getId());
    }


    public void deleteOrganisateur(Integer id) {
        organisateurRepository.deleteById(id);
    }

    public void blockOrganisateur(Integer id) {
        organisateurRepository.deleteById(id);
    }

    public Organisateur findByEmail(String email) {
        return organisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Organisateur not found with email: " + email));
    }


}