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
        System.out.println("TestListener.onTestStart: " + result.getName() + " startTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestListener.onTestSuccess: "
                + result.getName() + " endTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis())
                + " duration (mills): " + (result.getEndMillis() - result.getStartMillis())
        );

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TestListener.onTestFailure: " + result.getTestName()
                + " endTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis())
                + " duration (mills): " + (result.getEndMillis() - result.getStartMillis()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TestListener.onTestSkipped: " + result.getTestName()
                + " endTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis())
                + " duration (mills): " + (result.getEndMillis() - result.getStartMillis())
        );
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("TestListener.onTestFailedButWithinSuccessPercentage: " + result.getTestName()
                + " endTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis())
                + " duration (mills): " + (result.getEndMillis() - result.getStartMillis())
        );
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("TestListener.onTestFailedWithTimeout: " + result.getTestName()
                + " endTime: " + DateTimeUtils.convertMillisToDate(result.getStartMillis())
                + " duration (mills): " + (result.getEndMillis() - result.getStartMillis())
        );

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("TestListener.onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TestListener.onFinish");
    }


}
