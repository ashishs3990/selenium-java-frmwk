package com.swiggy.core.interfaces;

import org.testng.ITestContext;
import org.testng.ITestResult;

public interface CommunicationChannel {
    void updateSuiteResults(ITestContext context, ITestResult result);
}
