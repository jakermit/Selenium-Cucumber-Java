package com.piotr.chmiel.it.consulting.web.pages.locators;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.piotr.chmiel.it.consulting.web.base.BaseElementRepository;

@Getter
public class NewsPageElementRepository extends BaseElementRepository {

    @FindBy(css = ".fc-item__title a > span")
    private WebElement firstNewsTitleLocator;

    public NewsPageElementRepository(WebDriver driver) {
        super(driver);
    }
}
