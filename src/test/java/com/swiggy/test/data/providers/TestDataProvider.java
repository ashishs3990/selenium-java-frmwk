package com.swiggy.test.data.providers;

import com.swiggy.core.tdm.store.CSVStore;
import org.testng.annotations.DataProvider;

import java.net.URISyntaxException;

public class TestDataProvider {
    @DataProvider(name = "data-provider", parallel = true)
    //public Object[][] getTestData(Method method) { // We can pass method parameter to get which method calls data provider and get data based on the method name
    public Object[][] getTestData() throws URISyntaxException {
        /*return new String[][]{
                {"Bangalore", "2"},
                {"Bangalore", "3"}
        };*/
        return CSVStore.getRestaurantCountTestData();
    }
}
