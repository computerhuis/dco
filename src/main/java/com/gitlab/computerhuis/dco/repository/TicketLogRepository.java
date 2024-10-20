package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.model.TicketLog;
import com.gitlab.computerhuis.dco.repository.model.TicketLogPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketLogRepository extends JpaRepository<TicketLog, TicketLogPrimaryKey> {

    List<TicketLog> findByTicketId(Long ticketId);
}
