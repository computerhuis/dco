package com.gitlab.computerhuis.dco.repository.view;

import com.gitlab.computerhuis.dco.enumeration.StatusType;
import com.gitlab.computerhuis.dco.enumeration.TicketType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket_overview")
public class TicketOverview {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusType status;
    private Long computerId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    private LocalDateTime registered;
    private LocalDateTime unregistered;
    private String description;
    private String firstName;
    private String infix;
    private String lastName;
    private String manufacturer;
    private String model;

    public String getStatusName() {
        if (status != null) {
            return status.getLabel();
        }
        return null;
    }
}
