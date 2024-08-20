package com.gitlab.computerhuis.dco.repository;

import com.gitlab.computerhuis.dco.repository.view.TimesheetOverview;
import com.gitlab.computerhuis.dco.repository.view.TimesheetOverviewPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesheetOverviewRepository extends JpaRepository<TimesheetOverview, TimesheetOverviewPrimaryKey> {

    List<TimesheetOverview> findByPersonId(Long personId);
}
