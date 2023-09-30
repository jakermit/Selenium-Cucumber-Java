package com.piotr.chmiel.it.consulting.defintions;

import com.piotr.chmiel.it.consulting.testContext.TestContext;
import com.piotr.chmiel.it.consulting.web.driver_management.DriveManagement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp(Scenario scenario) {
        testContext.setDriver(new DriveManagement().provideDefaultDriver());
        testContext.setScenario(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        attachScreenshotWhenFailure(scenario);
        testContext.getDriver().quit();
        testContext.setDriver(null);
    }

    private void attachScreenshotWhenFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "test failure evidence");
        }
    }
}