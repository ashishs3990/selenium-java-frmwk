package com.swiggy.core.base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
public class BaseWebPage<T extends BaseWebPage<T>> {
    protected WebDriver driver;

    protected BaseWebPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentTitle() {
        String title = driver.getTitle();
        log.info("Title: " + title);
        return title;
    }

    public String getCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        log.info("CurrentURL: " + currentURL);
        return currentURL;
    }

    public void click(WebElement webElement) {
        log.info("Clicking " + webElement.toString());
        webElement.click();
    }


}
