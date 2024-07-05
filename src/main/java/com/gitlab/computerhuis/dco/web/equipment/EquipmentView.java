package com.gitlab.computerhuis.dco.web.equipment;

import com.gitlab.computerhuis.dco.repository.model.Equipment;
import com.gitlab.computerhuis.dco.repository.model.Person;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class EquipmentView {

    private Equipment equipment;
    private Person owner;
}
