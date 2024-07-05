package com.gitlab.computerhuis.dco.enumeration;

import com.gitlab.computerhuis.dco.config.MessageSourceBundles;

public enum EquipmentCategoryType {
    DESKTOP, LAPTOP, TABLET, MOBILE, SIM, USB_STICK;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.equipment.category." + name().toLowerCase());
    }
}
