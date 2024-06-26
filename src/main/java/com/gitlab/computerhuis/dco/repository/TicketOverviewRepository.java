package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.view.TicketOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketOverviewRepository extends JpaRepository<TicketOverview, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ticket_overview WHERE status != 'CLOSED'")
    List<TicketOverview> getActiveTickets();
}
