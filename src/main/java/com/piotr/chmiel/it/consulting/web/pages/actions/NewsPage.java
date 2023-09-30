package com.piotr.chmiel.it.consulting.web.pages.actions;

import com.piotr.chmiel.it.consulting.web.base.BasePage;
import com.piotr.chmiel.it.consulting.web.pages.locators.NewsPageElementRepository;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class NewsPage extends BasePage<NewsPageElementRepository> {

    public static String NEWS_PAGE_URL = "https://www.theguardian.com/tone/news";

    public NewsPage(WebDriver driver) {
        super(driver, new NewsPageElementRepository(driver));
    }

    @Override
    public NewsPage waitUntilIsLoaded() {
        await("Wait until first news title is loaded")
                .atMost(5, TimeUnit.SECONDS)
                .with()
                .pollInterval(100, TimeUnit.MILLISECONDS)
                .ignoreExceptions()
                .until(() -> elementRepository.getFirstNewsTitleLocator().getText().length() > 0);
        return this;
    }

    public NewsPage open() {
        driver.get(NEWS_PAGE_URL);
        waitUntilIsLoaded();
        return this;
    }

    public String getFirstNewsTitle() {
        return elementRepository.getFirstNewsTitleLocator().getText();
    }
}
