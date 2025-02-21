package com.example.Event.repositories;

import com.example.Event.models.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Integer> {
}
