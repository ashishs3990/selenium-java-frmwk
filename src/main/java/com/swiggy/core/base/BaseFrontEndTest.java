package com.swiggy.core.base;

import com.swiggy.core.model.TestEnvironment;
import com.swiggy.core.utils.ConfigReaderUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseFrontEndTest extends BaseTest {
    private final ThreadLocal<WebDriver> threadLocal = new InheritableThreadLocal<>();
    public String baseURL;
    public String browserName;
    protected WebDriver driver;

    @BeforeSuite
    @Parameters({"test.env", "browser.name"})
    public void initSuite(String env, String browserType, ITestContext context) throws IOException {
        baseURL = getBaseURL(env);
        browserName = browserType;
        System.out.println("Execution Environment: " + env + " BrowserName: " + browserType + " BaseURL: " + baseURL);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        driver = WebDriverFactory.getWebDriver(browserName);
        threadLocal.set(driver);
        driver.get(baseURL);
    }

    private String getBaseURL(String testEnvironment) throws IOException {
        TestEnvironment te = TestEnvironment.valueOf(testEnvironment);
        return switch (te) {
            case PROD -> ConfigReaderUtils.getConfigValue("ENV_PROD_URL");
            case QA, DEV, STG, default -> "NA";
        };
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        threadLocal.remove();
    }

    protected WebDriver getDriver() {
        return threadLocal.get();
    }
}
