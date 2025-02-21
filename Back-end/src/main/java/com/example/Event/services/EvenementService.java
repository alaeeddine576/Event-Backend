package com.example.Event.services;

import com.example.Event.enums.Status;
import com.example.Event.models.Evenment;
import com.example.Event.repositories.EvenementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;

    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public List<Evenment> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public Evenment getEvenementById(int id) {
        return evenementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evenement not found with id: " + id));
    }

    public Evenment createEvenement(String title, String localisation, LocalDate eventDate, Integer price, Status status, MultipartFile file) throws IOException, IOException {
        Evenment evenment = new Evenment();
        evenment.setTitle(title);
        evenment.setLocalisation(localisation);
        evenment.setEventDate(eventDate);
        evenment.setPrice(price);
        evenment.setStatus(status);
        evenment.setImage(file.getBytes());

        return evenementRepository.save(evenment);
    }

    public Evenment updateEvenement(int id, Evenment evenementDetails) {
        Evenment existingEvenement = getEvenementById(id);
        BeanUtils.copyProperties(evenementDetails , existingEvenement);
        return evenementRepository.save(existingEvenement);
    }

    public void deleteEvenement(int id) {
        if (!evenementRepository.existsById(id)) {
            throw new RuntimeException("Evenement not found with id: " + id);
        }
        evenementRepository.deleteById(id);
    }
}
