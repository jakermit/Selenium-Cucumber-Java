package com.piotr.chmiel.it.consulting.web.pages.locators;

import com.piotr.chmiel.it.consulting.web.base.BaseElementRepository;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class BingResultsPageElementRepository extends BaseElementRepository {

    @FindBy(css = "#b_results > li")
    private List<WebElement> resultsHeaderLocator;

    @FindBy(css = "#b_tween_searchResults")
    private List<WebElement> resultsStats;

    @FindBy(css = "#b_results > li, #b_tween_searchResults")
    private WebElement resultStatsOrNoResultsLocator;

    public BingResultsPageElementRepository(WebDriver driver) {
        super(driver);
    }
}
