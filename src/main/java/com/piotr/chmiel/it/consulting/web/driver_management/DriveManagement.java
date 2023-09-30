package com.piotr.chmiel.it.consulting.web.driver_management;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriveManagement {
    public WebDriver provideDefaultDriver() {
        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
