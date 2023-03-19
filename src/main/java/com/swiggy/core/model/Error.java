package com.swiggy.core.model;

public enum Error {
    RUNNER(1, "Error In Runner");

    private final int code;
    private final String description;

    private Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
