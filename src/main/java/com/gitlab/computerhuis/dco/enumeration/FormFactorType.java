package com.gitlab.computerhuis.dco.enumeration;

import com.gitlab.computerhuis.dco.config.MessageSourceBundles;

public enum FormFactorType {
    DESKTOP, LAPTOP;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.computer." + name().toLowerCase());
    }
}
