package com.swiggy.core.base;

import com.swiggy.core.model.BrowserType;
import com.swiggy.core.model.TestEnvironment;
import com.swiggy.core.utils.ConfigReaderUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

public class BaseFrontEndTest {

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
        setupDriver(browserName);
    }

    private String getBaseURL(String testEnvironment) throws IOException {
        TestEnvironment te = TestEnvironment.valueOf(testEnvironment);
        switch (te) {
            case PROD:
                return ConfigReaderUtils.getConfigValue("ENV_PROD_URL");
            case QA:
            case DEV:
            case STG:
            default:
                return "NA";
        }
    }

    private void setupDriver(String browserType) throws IOException {
        BrowserType browser = BrowserType.valueOf(browserType);
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReaderUtils.getConfigValue("IMPLICIT_TIMEOUT"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReaderUtils.getConfigValue("PAGE_LOAD_TIMEOUT"))));
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
