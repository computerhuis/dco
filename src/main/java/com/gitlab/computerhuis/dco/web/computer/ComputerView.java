package com.gitlab.computerhuis.dco.web.computer;

import com.gitlab.computerhuis.dco.repository.model.Computer;
import com.gitlab.computerhuis.dco.repository.model.Person;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class ComputerView {

    private Computer computer;
    private Person owner;
}
