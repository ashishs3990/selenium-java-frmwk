package com.swiggy.core.base;

import com.swiggy.core.model.BrowserType;
import com.swiggy.core.utils.ConfigReaderUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;

@Slf4j
@UtilityClass
public class WebDriverFactory {

    public WebDriver getWebDriver(String browserName) throws IOException {
        log.info("BrowserName: " + browserName);
        BrowserType browser = BrowserType.valueOf(browserName);
        WebDriver driver;
        switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                //options.addArguments("headless"); //For headless execution
                driver = WebDriverManager.chromedriver().capabilities(options).create();
            }
            case FIREFOX -> {
                driver = WebDriverManager.firefoxdriver().create();
            }
            case EDGE -> {
                driver = WebDriverManager.edgedriver().create();
            }
            case SAFARI -> {
                driver = WebDriverManager.safaridriver().create();
            }
            default -> {
                throw new UnsupportedOperationException("Browser " + browser + " not supported!");
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReaderUtils.getConfigValue("IMPLICIT_TIMEOUT"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReaderUtils.getConfigValue("PAGE_LOAD_TIMEOUT"))));
        return driver;
    }
}
