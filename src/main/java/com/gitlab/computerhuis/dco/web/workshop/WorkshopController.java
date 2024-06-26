package com.gitlab.computerhuis.dco.web.workshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/workshop")
@Controller
class WorkshopController {

    @RequestMapping(method = GET)
    public String dashboard() {
        return "/workshop/index";
    }
}
