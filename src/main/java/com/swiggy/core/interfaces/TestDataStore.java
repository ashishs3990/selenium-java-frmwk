package com.swiggy.core.interfaces;

public interface TestDataStore {
    void insertRandomizedTestData(TestDataResponse testDataResponse);

    TestData getTestData(TestDataRequest testDataRequest);

    void deleteTestData(TestDataRequest testDataRequest);

    void updateTestData(TestDataRequest testDataRequest);
}
