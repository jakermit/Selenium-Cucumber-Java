package com.piotr.chmiel.it.consulting.web.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage<ELEMENT_REPOSITORY_CLASS extends BaseElementRepository> implements IsLoaded {

    protected ELEMENT_REPOSITORY_CLASS elementRepository;
    protected WebDriver driver;

    public BasePage(WebDriver driver, ELEMENT_REPOSITORY_CLASS elementRepository) {
        this.driver = driver;
        this.elementRepository = elementRepository;
    }
}

