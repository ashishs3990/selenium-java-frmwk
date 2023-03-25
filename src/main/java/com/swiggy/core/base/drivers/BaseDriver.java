package com.swiggy.core.base.drivers;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public abstract class BaseDriver {

    protected final WebDriver webDriver;

    public BaseDriver() {
        webDriver = this.createDriver();
    }

    protected abstract WebDriver createDriver();
}


