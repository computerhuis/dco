package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
