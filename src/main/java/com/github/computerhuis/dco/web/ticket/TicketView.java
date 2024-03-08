package com.github.computerhuis.dco.web.ticket;

import com.github.computerhuis.dco.repository.model.Ticket;
import com.github.computerhuis.dco.repository.model.TicketLog;
import com.github.computerhuis.dco.repository.model.TicketStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
class TicketView {
    private Ticket ticket;
    private List<TicketStatus> statusList;
    private List<TicketLog> logList;
}
