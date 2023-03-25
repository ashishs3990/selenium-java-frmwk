package com.swiggy.core.base;

import com.swiggy.core.base.drivers.*;
import com.swiggy.core.model.BrowserType;
import com.swiggy.core.model.PlatformType;
import com.swiggy.core.utils.ConfigReaderUtils;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Duration;

@Slf4j
@UtilityClass
public class DriverFactory {

    public BaseDriver getBaseDriver(String platformName, String browserName) throws IOException {
        log.info("PlatformName: " + platformName + " BrowserName: " + browserName);
        BrowserType browserType = BrowserType.valueOf(browserName);
        BaseDriver driver = null;
        switch (browserType) {
            case CHROME -> {
                driver = new CustomChromeDriver();
            }
            case FIREFOX -> {
                driver = new CustomFirefoxDriver();
            }
            case EDGE -> {
                if (platformName.equals(PlatformType.MAC.toString()) || platformName.equals(PlatformType.LINUX.toString()))
                    throw new UnsupportedOperationException("platform: " + platformName + " browser: " + browserName + " not supported!");
                driver = new CustomEdgeDriver();
            }
            case SAFARI -> {
                driver = new CustomSafariDriver();
            }
            default -> {
                throw new UnsupportedOperationException("Browser " + browserName + " not supported!");
            }
        }

        driver.getWebDriver().manage().deleteAllCookies();
        driver.getWebDriver().manage().window().maximize();
        driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReaderUtils.getConfigValue("IMPLICIT_TIMEOUT"))));
        driver.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigReaderUtils.getConfigValue("PAGE_LOAD_TIMEOUT"))));
        return driver;
    }
}
