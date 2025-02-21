package com.example.Event.controllers;

import com.example.Event.DTOs.EvenmentDTO;
import com.example.Event.enums.Status;
import com.example.Event.models.Evenment;
import com.example.Event.repositories.EvenementRepository;
import com.example.Event.services.EvenementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evenements")
public class EvenmentController {


    private final  EvenementService evenementService;
    private final EvenementRepository evenementRepository;

    public EvenmentController(EvenementService evenementService, EvenementRepository evenementRepository) {
        this.evenementService = evenementService;
        this.evenementRepository = evenementRepository;
    }

    @GetMapping
    public ResponseEntity<List<Evenment>> getAllEvenements() {
        List<Evenment> evenements = evenementService.getAllEvenements();
        return ResponseEntity.ok(evenements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evenment> getEvenmentById(@PathVariable("id") int id) {
        Evenment Evenment = evenementService.getEvenementById(id);
        return ResponseEntity.ok(Evenment);
    }

    @PostMapping("/create")
    public ResponseEntity<Evenment> createEvenement(
            @RequestParam("title") String title,
            @RequestParam("localisation") String localisation,
            @RequestParam("eventDate") String eventDate, // String car LocalDate ne s'envoie pas directement
            @RequestParam("price") Integer price,
            @RequestParam("status") Status status,
            @RequestParam("file") MultipartFile file) {

        try {
            LocalDate date = LocalDate.parse(eventDate); // Conversion de String en LocalDate
            Evenment evenement = evenementService.createEvenement(title, localisation, date, price, status, file);
            return ResponseEntity.ok(evenement);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvenment(@PathVariable("id") int id) {
        evenementService.deleteEvenement(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evenment> updateEvenment(
            @PathVariable int id,
            @RequestParam("title") String title,
            @RequestParam("localisation") String localisation,
            @RequestParam("eventDate") String eventDate, // String car LocalDate ne s'envoie pas directement
            @RequestParam("price") Integer price,
            @RequestParam("status") Status status,
            @RequestParam("file") MultipartFile file) throws IOException {

        // Conversion de String en LocalDate
        LocalDate date = LocalDate.parse(eventDate);

        // Récupérer l'événement existant depuis la base de données
        Optional<Evenment> existingEvenment = evenementRepository.findById(id);
        if (existingEvenment.isEmpty()) {
            return ResponseEntity.notFound().build();  // Retourne 404 si l'événement n'existe pas
        }

        Evenment evenement = existingEvenment.get();
        evenement.setTitle(title);
        evenement.setLocalisation(localisation);
        evenement.setEventDate(date);
        evenement.setPrice(price);
        evenement.setStatus(status);

        // Conversion du fichier MultipartFile en tableau d'octets (byte[])
        byte[] imageBytes = file.getBytes();
        evenement.setImage(imageBytes); // Mise à jour de l'image

        // Mise à jour de l'événement via le service
        Evenment updatedEvenment = evenementService.updateEvenement(id, evenement);

        return ResponseEntity.ok(updatedEvenment);
    }


}