package com.github.computerhuis.dco.enumeration;

import com.github.computerhuis.dco.config.MessageSourceBundles;

public enum StatusType {
    OPEN, IN_PROGRESS, READY, CUSTOMER_INFORMED, CLOSED;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.status." + name().toLowerCase());
    }
}
