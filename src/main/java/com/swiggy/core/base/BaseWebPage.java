package com.swiggy.core.base;

import org.openqa.selenium.WebDriver;

public class BaseWebPage {
    protected WebDriver driver;

    protected BaseWebPage(WebDriver driver) {
        this.driver = driver;
    }
}
