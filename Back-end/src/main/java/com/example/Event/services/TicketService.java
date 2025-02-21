package com.example.Event.services;


import com.example.Event.models.Ticket;
import com.example.Event.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {


    private final  TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(int id, Ticket ticket) {
        Ticket existingTicket = getTicketById(id);
        existingTicket.setDateAchat(ticket.getDateAchat());
        existingTicket.setMontantPaiement(ticket.getMontantPaiement());
        existingTicket.setStatut(ticket.getStatut());
        existingTicket.setNbPlaces(ticket.getNbPlaces());
        existingTicket.setPrixTotal(ticket.getPrixTotal());
        return ticketRepository.save(existingTicket);
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }
}