package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
}
