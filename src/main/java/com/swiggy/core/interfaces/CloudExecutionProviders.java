package com.swiggy.core.interfaces;

public interface CloudExecutionProviders {
    void connect();

    void disconnect();

    void fetchData();
}
