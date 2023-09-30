package com.piotr.chmiel.it.consulting.web.pages.locators;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.piotr.chmiel.it.consulting.web.base.BaseElementRepository;

import java.util.List;

@Getter
public class GoogleResultsPageElementRepository extends BaseElementRepository {

    @FindBy(css = "#rcnt h3")
    private List<WebElement> resultsHeaderLocator;

    @FindBy(id = "result-stats")
    private WebElement resultStats;

    @FindBy(css = "#hdtb-tls, .IUOThf div:nth-child(3) > div > span")
    private WebElement tools;

    @FindBy(css = "#tn_1 > span:last-child")
    private WebElement resultsSettings;

    @FindBy(css = ".muaC1e.eTnfyc > span:last-child g-menu-item:last-child, #lb > div > g-menu > g-menu-item:nth-child(2) > div > a")
    private WebElement exactOption;


    public GoogleResultsPageElementRepository(WebDriver driver) {
        super(driver);
    }
}
