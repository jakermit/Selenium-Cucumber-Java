package com.piotr.chmiel.it.consulting.web.pages.actions;

import com.piotr.chmiel.it.consulting.web.base.BasePage;
import com.piotr.chmiel.it.consulting.web.pages.locators.BingPageElementRepository;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class BingPage extends BasePage<BingPageElementRepository> {

    public static String BING_PAGE_URL = "https://www.bing.com/";

    public BingPage(WebDriver driver) {
        super(driver, new BingPageElementRepository(driver));
    }

    @Override
    public BingPage waitUntilIsLoaded() {
        await("Wait until bing search input is loaded")
                .atMost(5, TimeUnit.SECONDS)
                .with()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .ignoreExceptions()
                .until(() -> elementRepository.getSearchInput().isDisplayed());
        return this;
    }

    public BingPage open() {
        driver.get(BING_PAGE_URL);
        waitUntilIsLoaded();
        return this;
    }

    public BingResultsPage search(String searchKeyword) {
        elementRepository.getSearchInput().sendKeys(searchKeyword);
        elementRepository.getSearchInput().submit();
        return new BingResultsPage(driver);
    }
}
