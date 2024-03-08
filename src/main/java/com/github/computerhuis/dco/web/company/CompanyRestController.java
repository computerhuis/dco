package com.github.computerhuis.dco.web.company;

import com.github.computerhuis.dco.repository.CompanyRepository;
import com.github.computerhuis.dco.repository.model.Company;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/company")
@RestController
class CompanyRestController {

    private final CompanyRepository companyRepository;

    @GetMapping
    Map<String, List<Company>> get() {
        val result = new HashMap<String, List<Company>>();
        val data = companyRepository.findAll();
        result.put("data", data);

        return result;
    }
}
