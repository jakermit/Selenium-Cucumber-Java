package com.piotr.chmiel.it.consulting.web.pages.actions;

import com.piotr.chmiel.it.consulting.web.base.BasePage;
import com.piotr.chmiel.it.consulting.web.pages.locators.GooglePageElementRepository;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class GooglePage extends BasePage<GooglePageElementRepository> {

    public static String GOOGLE_PAGE_URL = "https://www.google.com/";

    public GooglePage(WebDriver driver) {
        super(driver, new GooglePageElementRepository(driver));
    }

    @Override
    public GooglePage waitUntilIsLoaded() {
        await("Wait until google search input is loaded")
                .atMost(5, TimeUnit.SECONDS)
                .with()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .ignoreExceptions()
                .until(() -> elementRepository.getSearchInput().isDisplayed());
        return this;
    }

    public GooglePage open() {
        driver.get(GOOGLE_PAGE_URL);
        elementRepository.getAcceptCookiesButton().click();
        waitUntilIsLoaded();
        return this;
    }

    public GoogleResultsPage search(String searchKeyword) {
        elementRepository.getSearchInput().sendKeys(searchKeyword);
        elementRepository.getSearchInput().submit();
        return new GoogleResultsPage(driver);
    }
}
