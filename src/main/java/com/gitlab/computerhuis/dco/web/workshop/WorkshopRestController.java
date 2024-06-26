package com.gitlab.computerhuis.dco.web.workshop;

import com.gitlab.computerhuis.dco.repository.TicketOverviewRepository;
import com.gitlab.computerhuis.dco.repository.view.TicketOverview;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/workshop")
@RequiredArgsConstructor
@RestController
class WorkshopRestController {
    private final TicketOverviewRepository ticketOverviewRepository;

    @GetMapping
    Map<String, List<TicketOverview>> get() {
        val result = new HashMap<String, List<TicketOverview>>();
        val data = ticketOverviewRepository.getActiveTickets();
        result.put("data", data);

        return result;
    }
}
