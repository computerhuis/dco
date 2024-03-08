package com.github.computerhuis.dco.web.computer;

import com.github.computerhuis.dco.repository.model.Company;
import com.github.computerhuis.dco.repository.model.Computer;
import com.github.computerhuis.dco.repository.model.Person;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class ComputerView {

    private Computer computer;
    private Person owner;
    private Company donor;
}
