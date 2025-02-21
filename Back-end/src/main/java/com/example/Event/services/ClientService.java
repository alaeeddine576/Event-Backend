package com.example.Event.services;

import com.example.Event.DTOs.ClientDTO;
import com.example.Event.models.Client;
import com.example.Event.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService  {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client saveNewClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setNom(clientDTO.getNom());
        client.setPrenom(clientDTO.getPrenom());
        client.setEmail(clientDTO.getEmail());
        client.setPassword(clientDTO.getPassword());
        client.setLogin(clientDTO.getEmail());
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }


    public Client updateClient(Client client) {
        if (clientRepository.existsById(client.getId())) {
            return clientRepository.save(client);
        }
        throw new RuntimeException("Client not found with id: " + client.getId());
    }


    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }


    public List<Client> findClientsByNom(String nom) {
        return clientRepository.findByNom(nom);
    }


    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found with email: " + email));
    }
}