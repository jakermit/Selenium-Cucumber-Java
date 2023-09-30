package com.piotr.chmiel.it.consulting.web.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseElementRepository {

    public BaseElementRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
