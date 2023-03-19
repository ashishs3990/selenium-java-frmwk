package com.swiggy.core.listeners;

import com.swiggy.core.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        log.info("TestListener.onTestStart: TCName: " + result.getName() + " | startTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("TestListener.onTestSuccess: TCName: "
                + result.getName() + " | endTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis())
                + " | duration (mills): " + (result.getEndMillis() - result.getStartMillis())
        );

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("TestListener.onTestFailure: TCName: " + result.getTestName()
                + " | endTime: " + DateTimeUtils.convertMillisToDate(result.getEndMillis())
                + " | duration (mills): " + (result.getEndMillis() - result.getStartMillis()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("TestListener.onTestSkipped:  TCName: " + result.getTestName()
                + " | endTime: " + DateTimeUtils.convertMillisToDate(result.getEndMillis())
                + " | duration (mills): " + (result.getEndMillis() - result.getStartMillis()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("TestListener.onTestFailedButWithinSuccessPercentage:  TCName: " + result.getTestName()
                + " | endTime: " + DateTimeUtils.convertMillisToDate(result.getEndMillis())
                + " | duration (mills): " + (result.getEndMillis() - result.getStartMillis()));
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info("TestListener.onTestFailedWithTimeout:  TCName: " + result.getTestName()
                + " | endTime: " + DateTimeUtils.convertMillisToDate(result.getEndMillis())
                + " | duration (mills): " + (result.getEndMillis() - result.getStartMillis()));
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("TestListener.onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("TestListener.onFinish");
    }


}
