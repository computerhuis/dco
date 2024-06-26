package com.gitlab.computerhuis.dco.web.timesheet;

import com.gitlab.computerhuis.dco.repository.TimesheetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/timesheet")
@Validated
@Controller
class TimesheetController {

    private final TimesheetRepository timesheetRepository;

    @GetMapping
    public String all() {
        return "/timesheet/all";
    }

    @GetMapping("/{id}")
    public String open(@PathVariable("id") final Long id, final Model model) {
        model.addAttribute(timesheetRepository.findById(id));
        return "/timesheet/index";
    }
}
