package com.swiggy.core.model;

public enum TestPriority {

    CRITICAL("CRITICAL"), P1("P1"), P2("P2"), P3("P3"), P4("P4"), P5("P5");

    private final String priority;

    TestPriority(String priorityIn) {
        this.priority = priorityIn;
    }

    public String getPriority() {
        return priority;
    }
}
