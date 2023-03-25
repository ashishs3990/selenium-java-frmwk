package com.swiggy.core.model;

import lombok.Getter;

@Getter
public enum TestSeverity {
    CRITICAL("CRITICAL"), S1("S1"), S2("S2"), S3("S3"), S4("S4"), S("S5");
    private final String severity;

    TestSeverity(String severity) {
        this.severity = severity;
    }
}
