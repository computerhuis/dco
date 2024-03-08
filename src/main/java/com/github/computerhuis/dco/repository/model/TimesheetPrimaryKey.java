package com.github.computerhuis.dco.repository.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class TimesheetPrimaryKey implements Serializable {

    private static final long serialVersionUID = -8714404286147373620L;

    private Long personId;
    private Long activityId;
}
