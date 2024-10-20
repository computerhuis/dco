package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.view.TicketLogOverview;
import com.gitlab.computerhuis.dco.repository.view.TicketLogOverviewPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketLogOverviewRepository extends JpaRepository<TicketLogOverview, TicketLogOverviewPrimaryKey> {

    List<TicketLogOverview> findByTicketId(Long ticketId);
}
