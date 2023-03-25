package com.swiggy.pages;

import com.swiggy.core.base.BaseWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuestHomePage extends BaseWebPage<GuestHomePage> {

    @FindBy(xpath = "//div[@id='all_restaurants']//descendant::div[contains(text(),'restaurants')]")
    WebElement restaurantCount;

    public GuestHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getRestaurantsCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(restaurantCount));
        return Integer.parseInt(restaurantCount.getText().split("\\s")[0]);
    }
}
