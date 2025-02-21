package com.example.Event.controllers;

import com.example.Event.DTOs.ClientDTO;
import com.example.Event.models.Client;
import com.example.Event.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveNewClient(clientDTO);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Client> getClientByEmail(@PathVariable String email) {
        return ResponseEntity.ok(clientService.findByEmail(email));
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<List<Client>> getClientsByNom(@PathVariable String nom) {
        return ResponseEntity.ok(clientService.findClientsByNom(nom));
    }
}