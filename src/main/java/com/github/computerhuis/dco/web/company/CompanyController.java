package com.github.computerhuis.dco.web.company;

import com.github.computerhuis.dco.repository.CompanyRepository;
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
@RequestMapping("/company")
@Validated
@Controller
class CompanyController {

    private final CompanyRepository companyRepository;

    @GetMapping
    public String all() {
        return "/company/all";
    }

    @GetMapping("/{id}")
    public String open(@PathVariable("id") final Long id, final CompanyView view) {

        val company = companyRepository.findById(id);
        company.ifPresent(view::setCompany);

        return "/company/index";
    }
}
