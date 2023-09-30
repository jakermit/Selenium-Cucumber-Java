package com.piotr.chmiel.it.consulting.web.pages.locators;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.piotr.chmiel.it.consulting.web.base.BaseElementRepository;

@Getter
public class GooglePageElementRepository extends BaseElementRepository {

    @FindBy(id = "APjFqb")
    private WebElement searchInput;

    @FindBy(id = "L2AGLb")
    private WebElement acceptCookiesButton;

    public GooglePageElementRepository(WebDriver driver) {
        super(driver);
    }
}
