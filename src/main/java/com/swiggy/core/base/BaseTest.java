package com.swiggy.core.base;

import com.swiggy.core.annotations.TestInfo;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Slf4j
public abstract class BaseTest {

    public static final String separator = "**************************************************************************************************";

    @BeforeSuite
    @Parameters("test.env")
    public void beforeSuite(String testEnvironment, ITestContext context) {
        System.out.println(separator);
        log.info("SuiteName: " + context.getSuite().getName());
        log.info("TestEnvironment: " + testEnvironment);
        System.out.println(separator);

    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BaseTest.beforeTest");
    }


    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.println(separator);
        System.out.println("Starting: " + method.getName());
        TestInfo testInfo = method.getAnnotation(TestInfo.class);
        System.out.println(testInfo.toString());
    }

    @AfterMethod
    public void afterMethod(Method method) {
        System.out.println("Ending: " + method.getName());
        System.out.println(separator);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("BaseTest.afterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(separator);
    }
}
