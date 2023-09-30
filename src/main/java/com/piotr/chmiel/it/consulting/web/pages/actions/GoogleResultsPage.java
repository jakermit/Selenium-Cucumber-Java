package com.piotr.chmiel.it.consulting.web.pages.actions;

import com.piotr.chmiel.it.consulting.web.base.BasePage;
import com.piotr.chmiel.it.consulting.web.pages.locators.GoogleResultsPageElementRepository;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class GoogleResultsPage extends BasePage<GoogleResultsPageElementRepository> {

    public GoogleResultsPage(WebDriver driver) {
        super(driver, new GoogleResultsPageElementRepository(driver));
    }

    @Override
    public GoogleResultsPage waitUntilIsLoaded() {
        await("Wait until google search results are loaded")
                .atMost(15, TimeUnit.SECONDS)
                .with()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .ignoreExceptions()
                .until(() -> elementRepository.getResultsHeaderLocator().size() > 0 || elementRepository.getResultStats().getText().length() > 0);
        return this;
    }

    public Integer getResultsAmount() {
        waitUntilIsLoaded();
        //in current implementation I assume that we can count results amount base on titles amount from first page
        //another way is to fetch total amount from string were total amount is present
        return elementRepository.getResultsHeaderLocator().size();
    }

    public GoogleResultsPage turnOnExactResults() {
        await("Wait until tools option appears")
                .atMost(15, TimeUnit.SECONDS)
                .ignoreExceptions()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .until(() -> elementRepository.getTools().isDisplayed());
        elementRepository.getTools().click();
        await("Wait until settings option appears")
                .atMost(15, TimeUnit.SECONDS)
                .ignoreExceptions()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .until(() -> elementRepository.getResultsSettings().isDisplayed());
        elementRepository.getResultsSettings().click();
        await("Wait until exact option appears")
                .atMost(3, TimeUnit.SECONDS)
                .ignoreExceptions()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .until(() -> elementRepository.getExactOption().isDisplayed());
        elementRepository.getExactOption().click();
        return this;
    }
}
