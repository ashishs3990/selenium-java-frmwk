package com.swiggy.core.listeners;

import com.swiggy.core.utils.ConfigReaderUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * Created by: Ashish S on Jun 2021
 */
public class RetryAnalyzerListener implements IRetryAnalyzer {
    private int retryCounter = Integer.parseInt(ConfigReaderUtils.getConfigValue("RETRY_COUNT"));

    public RetryAnalyzerListener() throws IOException {
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCounter == 0) return false;
        retryCounter--;
        return true;
    }
}
