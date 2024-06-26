package com.gitlab.computerhuis.dco.web.postal;

import com.gitlab.computerhuis.dco.repository.PostalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/postal")
@Validated
@Controller
class PostalController {

    private final PostalRepository postalRepository;

    @GetMapping
    public String all() {
        return "/postal/all";
    }

    @GetMapping("/{code}")
    public String open(@PathVariable("code") final String code, final PostalView view) {
        val postal = postalRepository.findById(code);
        postal.ifPresent(view::setPostal);
        return "/postal/index";
    }
}
