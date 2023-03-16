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
    @FindBy(id = "location")
    private WebElement deliveryLocationEditField;

    //@FindBy(xpath = "//input[@id='location']//ancestor::div[3]//a//span")
    @FindBy(xpath = "//span[text()='FIND FOOD']")
    private WebElement findFoodButton;


    public GuestWelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GuestHomePage selectLocation(String locationText, String tabIndex) {
        deliveryLocationEditField.clear();
        deliveryLocationEditField.sendKeys(locationText);
        String dynamicLocationXpath = "//button[@tabindex='%s']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(dynamicLocationXpath, tabIndex)))).click();
        return new GuestHomePage(driver);
    }

    public GuestHomePage clickFindFoodButton() {
        findFoodButton.click();
        return new GuestHomePage(driver);
    }

}
