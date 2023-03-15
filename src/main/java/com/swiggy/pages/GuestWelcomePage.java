package com.swiggy.pages;

import com.swiggy.core.base.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuestWelcomePage extends BaseWebPage {
    @FindBy(xpath = "//input[@name='location']")
    private WebElement deliveryLocationEditField;
    @FindBy(xpath = "//input[@id='location']//ancestor::div[3]//a//span")
    private WebElement findFoodButton; // Not in use as clicking on the search results navigates to the guest home page

    public GuestWelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GuestHomePage selectLocation(String locationText, String tabIndex) {
        deliveryLocationEditField.clear();
        deliveryLocationEditField.sendKeys(locationText);
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String dynamicLocationIndex = "//button[@tabindex='%s']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dynamicLocationIndex, tabIndex)))).click();
        return new GuestHomePage(driver);
    }

    public GuestHomePage clickFindFoodButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findFoodButton)).click();
        findFoodButton.click();
        return new GuestHomePage(driver);
    }
}
