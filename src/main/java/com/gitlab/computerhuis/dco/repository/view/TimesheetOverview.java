package com.gitlab.computerhuis.dco.repository.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "timesheet_overview")
@IdClass(TimesheetOverviewPrimaryKey.class)
public class TimesheetOverview {

    @Id
    private Long personId;
    @Id
    private Long activityId;
    @Id
    private LocalDateTime registered;
    private LocalDateTime unregistered;

    private String activityName;
    private String firstName;
    private String infix;
    private String lastName;

}
