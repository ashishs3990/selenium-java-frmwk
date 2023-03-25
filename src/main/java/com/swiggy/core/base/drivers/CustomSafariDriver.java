package com.swiggy.core.base.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class CustomSafariDriver extends BaseDriver {
    @Override
    protected WebDriver createDriver() {
        return WebDriverManager.safaridriver().create();
    }

}
