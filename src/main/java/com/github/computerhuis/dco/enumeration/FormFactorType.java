package com.github.computerhuis.dco.enumeration;

import com.github.computerhuis.dco.config.MessageSourceBundles;

public enum FormFactorType {
    DESKTOP, LAPTOP;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.computer." + name().toLowerCase());
    }
}
