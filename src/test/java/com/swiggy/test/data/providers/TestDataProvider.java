package com.swiggy.test.data.providers;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "data-provider", parallel = true)
    //public Object[][] getTestData(Method method) { // We can pass method parameter to get which method calls data provider and get data based on the method name
    public Object[][] getTestData() {
        return new String[][]{
                {"Bangalore", "2"},
                {"Bangalore", "3"}
        };
    }
}
