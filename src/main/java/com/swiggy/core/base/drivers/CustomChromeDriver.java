package com.swiggy.core.base.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Getter
public class CustomChromeDriver extends BaseDriver {
    @Override
    protected WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("headless"); //For headless execution
        return WebDriverManager.chromedriver().capabilities(options).create();
    }

}
