package com.gitlab.computerhuis.dco.web;

import lombok.val;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping
    public String redirect() {
        if (isUserLoggedIn()) {
            for (val role : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
                if ("ROLE_WORKSHOP".equals(role.getAuthority())) {
                    return "redirect:/workshop";
                }

                if ("ROLE_COUNTER".equals(role.getAuthority())) {
                    return "redirect:/counter";
                }

                if ("ROLE_EDUCATION".equals(role.getAuthority())) {
                    return "redirect:/education";
                }

                if ("ROLE_ADMIN".equals(role.getAuthority())) {
                    return "redirect:/admin";
                }
            }
        }
        return "redirect:/authenticate";
    }

    boolean isUserLoggedIn() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails;
    }
}
