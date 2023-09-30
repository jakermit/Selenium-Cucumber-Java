package com.piotr.chmiel.it.consulting.web.pages.actions;

import com.piotr.chmiel.it.consulting.web.base.BasePage;
import com.piotr.chmiel.it.consulting.web.pages.locators.BingResultsPageElementRepository;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class BingResultsPage extends BasePage<BingResultsPageElementRepository> {

    public BingResultsPage(WebDriver driver) {
        super(driver, new BingResultsPageElementRepository(driver));
    }

    @Override
    public BingResultsPage waitUntilIsLoaded() {
        await("Wait until bing search results are loaded")
                .atMost(10, TimeUnit.SECONDS)
                .with()
                .pollInterval(500, TimeUnit.MILLISECONDS)
                .ignoreExceptions()
                .until(() -> elementRepository.getResultStatsOrNoResultsLocator().getText().length() > 0);
        return this;
    }

    public Integer getResultsAmount() {
        waitUntilIsLoaded();
        if (elementRepository.getResultsStats().size() > 0) {
            //in current implementation I assume that we can count results amount base on titles amount from first page
            //another way is to fetch total amount from string were total amount is present
            return elementRepository.getResultsHeaderLocator().size();
        } else {
            return 0;
        }
    }
}
