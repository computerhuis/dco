package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.view.TicketStatusOverview;
import com.gitlab.computerhuis.dco.repository.view.TicketStatusOverviewPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketStatusOverviewRepository extends JpaRepository<TicketStatusOverview, TicketStatusOverviewPrimaryKey> {

    List<TicketStatusOverview> findByTicketId(Long ticketId);
}
