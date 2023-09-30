package com.piotr.chmiel.it.consulting.defintions;

import com.piotr.chmiel.it.consulting.testContext.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.piotr.chmiel.it.consulting.web.pages.actions.BingPage;
import com.piotr.chmiel.it.consulting.web.pages.actions.GooglePage;
import com.piotr.chmiel.it.consulting.web.pages.actions.GoogleResultsPage;
import com.piotr.chmiel.it.consulting.web.pages.actions.NewsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsValidationSteps extends BaseStep {

    private String articleTitle;
    private Integer resultsAmount;
    private NewsPage newsPage;

    public NewsValidationSteps(TestContext testContext) {
        super(testContext);
    }

    @Given("I am on The Guardian website's news section")
    public void iAmOnTheGuardianNewsWebsite() {
        newsPage = new NewsPage(getTestContext().getDriver()).open();
    }

    @When("I retrieve the title of the first news article")
    public void iRetrieveTheTitleOfFirstArticle() {
        articleTitle = newsPage.getFirstNewsTitle();
    }

    @And("I add quotes to the title")
    public void iAddQuotesToTheTitle() {
        articleTitle = "\"" + articleTitle + "\"";
    }

    @Then("I search Google for articles with the same title and count number of search results")
    public void iSearchGoogleForArticlesWithSameTitle() {
        getTestContext().getScenario().log("Article title: " + articleTitle);
        resultsAmount = new GooglePage(getTestContext().getDriver()).open().search(articleTitle).getResultsAmount();
    }

    @And("I turn on exact results on google and re-count number of search results")
    public void iTurnOnExactResultsOnGoogle() {
        resultsAmount = new GoogleResultsPage(getTestContext().getDriver()).turnOnExactResults().getResultsAmount();
    }

    @Then("I search Bing for articles with the same title and count number of search results")
    public void iSearchBingForArticlesWithSameTitle() {
        getTestContext().getScenario().log("Article title: " + articleTitle);
        resultsAmount = new BingPage(getTestContext().getDriver()).open().search(articleTitle).getResultsAmount();
    }

    @And("I count the number of search results")
    public void iCountTheNumberOfSearchResults() {
        new GoogleResultsPage(getTestContext().getDriver()).getResultsAmount();
    }

    @And("I consider the article valid if there are {int} or more matching results")
    public void iConsiderTheArticleValidIfThereAreOrMoreMatchingResults(int expectedAmount) {
        assertThat(resultsAmount).as("I consider the article valid if there are " + expectedAmount + " or more matching results. But was: " + resultsAmount).isGreaterThanOrEqualTo(expectedAmount);
    }
}
