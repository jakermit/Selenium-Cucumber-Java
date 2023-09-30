package com.piotr.chmiel.it.consulting.web.pages.locators;

import com.piotr.chmiel.it.consulting.web.base.BaseElementRepository;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class BingPageElementRepository extends BaseElementRepository {

    @FindBy(id = "sb_form_q")
    private WebElement searchInput;

    public BingPageElementRepository(WebDriver driver) {
        super(driver);
    }
}
