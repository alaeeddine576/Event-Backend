package com.example.Event.controllers;

import com.example.Event.models.Invitation;
import com.example.Event.services.InvitationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invitations")
public class InvitationController {


    private final InvitationService invitationService;

    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @GetMapping
    public ResponseEntity<List<Invitation>> getAllInvitations() {
        List<Invitation> invitations = invitationService.getAllInvitations();
        return ResponseEntity.ok(invitations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invitation> getInvitationById(@PathVariable("id") int id) {
        Invitation invitation = invitationService.getInvitationById(id);
        return ResponseEntity.ok(invitation);
    }

    @PostMapping
    public ResponseEntity<Invitation> createInvitation(@RequestBody Invitation invitation) {
        Invitation createdInvitation = invitationService.createInvitation(invitation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInvitation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvitation(@PathVariable("id") int id) {
        invitationService.deleteInvitation(id);
        return ResponseEntity.noContent().build();
    }
}