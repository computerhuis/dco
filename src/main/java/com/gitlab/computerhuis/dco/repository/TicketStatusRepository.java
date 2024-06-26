package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.model.TicketStatus;
import com.gitlab.computerhuis.dco.repository.model.TicketStatusPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketStatusRepository extends JpaRepository<TicketStatus, TicketStatusPrimaryKey> {

    List<TicketStatus> findByTicketId(Long ticketId);
}
