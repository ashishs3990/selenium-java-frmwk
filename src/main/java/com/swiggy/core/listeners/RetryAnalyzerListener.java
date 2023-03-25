package com.swiggy.core.listeners;

import com.swiggy.core.utils.ConfigReaderUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

/**
 * Created by: Ashish S on Jun 2021
 */
@Slf4j
public class RetryAnalyzerListener implements IRetryAnalyzer {
    private final int maxRetryCount;
    private int retryCounter = 1;

    public RetryAnalyzerListener() throws IOException {
        maxRetryCount = Integer.parseInt(ConfigReaderUtils.getConfigValue("RETRY_COUNT"));
    }

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCounter == maxRetryCount) return false;
        log.info(iTestResult.getTestName() + "(Retry " + retryCounter + ")");
        retryCounter++;
        return true;
    }
}
