package com.gitlab.computerhuis.dco.web.authenticate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.gitlab.computerhuis.dco.web.authenticate.Roles.*;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/authenticate")
@Controller
class AuthenticateController {

    private static final String LOGIN_VIEW = "/authenticate";

    @RequestMapping(method = GET)
    public String login(@RequestParam(required = false) final String role, final HttpServletRequest request) throws ServletException {
        if (isNotBlank(role)) {
            return autoLogin(role, request);
        }
        return LOGIN_VIEW;
    }

    private String autoLogin(@NonNull final String role, @NonNull final HttpServletRequest request) throws ServletException {
        if (WORKSHOP_USERNAME.equals(role)) {
            request.login(WORKSHOP_USERNAME, WORKSHOP_PASSWORD);
            return "redirect:/workshop";
        }

        if (COUNTER_USERNAME.equals(role)) {
            request.login(COUNTER_USERNAME, COUNTER_PASSWORD);
            return "redirect:/counter";
        }

        if (EDUCATION_USERNAME.equals(role)) {
            request.login(EDUCATION_USERNAME, EDUCATION_PASSWORD);
            return "redirect:/education";
        }

        if (ADMIN_USERNAME.equals(role)) {
            request.login(ADMIN_USERNAME, ADMIN_PASSWORD);
            return "redirect:/admin";
        }

        return LOGIN_VIEW;
    }
}
