package com.gitlab.computerhuis.dco.web.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/counter")
@Controller
class CounterController {
    @GetMapping
    public String index() {
        return "/counter/index";
    }

    @GetMapping("/register")
    public String register() {
        return "/counter/register";
    }
}
