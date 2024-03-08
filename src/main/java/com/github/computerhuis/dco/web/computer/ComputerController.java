package com.github.computerhuis.dco.web.computer;

import com.github.computerhuis.dco.repository.CompanyRepository;
import com.github.computerhuis.dco.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/computer")
@Validated
@Controller
class ComputerController {

    private final com.github.computerhuis.dco.repository.ComputerRepository computerRepository;
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;

    @GetMapping
    public String all() {
        return "/computer/all";
    }


    @Transactional(readOnly = true)
    @GetMapping("/{id}")
    public String open(@PathVariable("id") final Long id, final ComputerView view) {

        val computer = computerRepository.findById(id);
        if (computer.isPresent()) {
            view.setComputer(computer.get());

            if (computer.get().getCompanyId() != null) {
                val donor = companyRepository.findById(computer.get().getCompanyId());
                donor.ifPresent(view::setDonor);
            }

            if (computer.get().getPersonId() != null) {
                val owner = personRepository.findById(computer.get().getPersonId());
                owner.ifPresent(view::setOwner);
            }
        }
        return "/computer/index";
    }
}
