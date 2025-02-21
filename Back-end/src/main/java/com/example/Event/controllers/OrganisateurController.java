package com.example.Event.controllers;

import com.example.Event.models.Organisateur;
import com.example.Event.services.OrganisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/organisateurs")
public class OrganisateurController {

    @Autowired
    private final OrganisateurService organisateurService;

    public OrganisateurController(OrganisateurService organisateurService) {
        this.organisateurService = organisateurService;
    }

    @PostMapping
    public ResponseEntity<Organisateur> createOrganisateur(@RequestBody Organisateur organisateur) {
        return ResponseEntity.ok(organisateurService.saveOrganisateur(organisateur));
    }

    @GetMapping
    public ResponseEntity<List<Organisateur>> getAllOrganisateurs() {
        return ResponseEntity.ok(organisateurService.getAllOrganisateurs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organisateur> getOrganisateurById(@PathVariable Integer id) {
        return organisateurService.getOrganisateurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Organisateur> updateOrganisateur(@RequestBody Organisateur organisateur) {
        return ResponseEntity.ok(organisateurService.updateOrganisateur(organisateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganisateur(@PathVariable Integer id) {
        organisateurService.deleteOrganisateur(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Organisateur> getOrganisateurByEmail(@PathVariable String email) {
        return ResponseEntity.ok(organisateurService.findByEmail(email));
    }


}