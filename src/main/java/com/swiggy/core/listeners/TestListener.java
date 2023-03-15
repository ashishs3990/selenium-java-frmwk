package com.swiggy.core.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TestListener.onTestStart: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestListener.onTestSuccess: " + result.getName() + " - " + result.getEndMillis());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TestListener.onTestFailure");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TestListener.onTestSkipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("TestListener.onTestFailedButWithinSuccessPercentage");

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("TestListener.onTestFailedWithTimeout");

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
