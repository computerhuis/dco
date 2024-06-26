package com.gitlab.computerhuis.dco.enumeration;

import com.gitlab.computerhuis.dco.config.MessageSourceBundles;

public enum TicketType {
    REPAIR, ISSUE;

    public String getLabel() {
        return MessageSourceBundles.getLabel("enumeration.ticket." + name().toLowerCase());
    }
}
