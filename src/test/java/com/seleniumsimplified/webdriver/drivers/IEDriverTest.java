package com.seleniumsimplified.webdriver.drivers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.junit.Assert.assertTrue;

public class IEDriverTest {

    @Test

    public void driverIsKing() {

        WebDriver driver = new InternetExplorerDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");

        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));

    }
}
