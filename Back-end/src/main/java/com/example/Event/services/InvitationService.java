package com.example.Event.services;


import com.example.Event.models.Invitation;
import com.example.Event.repositories.InvitationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationService {


    private final  InvitationRepository invitationRepository;

    public InvitationService(InvitationRepository invitationRepository) {
        this.invitationRepository = invitationRepository;
    }

    public List<Invitation> getAllInvitations() {
        return invitationRepository.findAll();
    }

    public Invitation getInvitationById(int id) {
        return invitationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invitation not found with id: " + id));
    }

    public Invitation createInvitation(Invitation invitation) {
        return invitationRepository.save(invitation);
    }

    public void deleteInvitation(int id) {
        invitationRepository.deleteById(id);
    }

    //   public Invitation updateInvitation(int id, Invitation invitation) {
//       Invitation existingInvitation = getInvitationById(id);
//       existingInvitation.setDateEnvoi(invitation.getDateEnvoi());
//       existingInvitation.setDate_expiration(invitation.getDateExpiration());
//       existingInvitation.setIdDestinataire(invitation.getIdDestinataire());
//       existingInvitation.setStatut(invitation.getStatut());
//       existingInvitation.setEstAcceptee(invitation.isEstAcceptee());
//       existingInvitation.setCodeInvitation(invitation.getCodeInvitation());
//       existingInvitation.setMessage(invitation.getMessage());
//       existingInvitation.setEstRepondue(invitation.isEstRepondue());
//       return invitationRepository.save(existingInvitation);
//    }
}