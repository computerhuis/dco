package com.github.computerhuis.dco.repository.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class TicketLogPrimaryKey implements Serializable {

    private static final long serialVersionUID = 8813358491304643702L;

    private Long ticketId;
    private LocalDateTime date;
}
