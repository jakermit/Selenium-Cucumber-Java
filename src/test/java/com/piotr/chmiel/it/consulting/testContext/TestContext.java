package com.piotr.chmiel.it.consulting.testContext;

import io.cucumber.java.Scenario;
import lombok.Data;
import org.openqa.selenium.WebDriver;

@Data
public class TestContext {
    private WebDriver driver;
    private Scenario scenario;
}
