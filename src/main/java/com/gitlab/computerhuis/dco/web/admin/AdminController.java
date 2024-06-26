package com.gitlab.computerhuis.dco.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/admin")
@Controller
class AdminController {

    @RequestMapping(method = GET)
    public String dashboard() {
        return "/admin/index";
    }
}
