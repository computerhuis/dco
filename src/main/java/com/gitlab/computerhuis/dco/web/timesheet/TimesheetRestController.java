package com.gitlab.computerhuis.dco.web.timesheet;

import com.gitlab.computerhuis.dco.repository.TimesheetRepository;
import com.gitlab.computerhuis.dco.repository.model.Timesheet;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/timesheet")
@RestController
class TimesheetRestController {

    private final TimesheetRepository timesheetRepository;

    @GetMapping
    Map<String, List<Timesheet>> get() {
        val result = new HashMap<String, List<Timesheet>>();
        val data = timesheetRepository.findAll();
        result.put("data", data);

        return result;
    }
}
