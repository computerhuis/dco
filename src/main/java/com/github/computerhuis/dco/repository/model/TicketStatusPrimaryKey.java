package com.github.computerhuis.dco.repository.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class TicketStatusPrimaryKey implements Serializable {

    private static final long serialVersionUID = -8133452964785904525L;

    private Long ticketId;
    private LocalDateTime date;
}
