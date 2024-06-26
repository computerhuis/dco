package com.gitlab.computerhuis.dco.web.computer;

import com.gitlab.computerhuis.dco.repository.ComputerRepository;
import com.gitlab.computerhuis.dco.repository.model.Computer;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/computer")
@RestController
class ComputerRestController {

    private final ComputerRepository computerRepository;

    @GetMapping
    Map<String, List<Computer>> get() {
        val result = new HashMap<String, List<Computer>>();
        val data = computerRepository.findAll();
        result.put("data", data);

        return result;
    }
}
