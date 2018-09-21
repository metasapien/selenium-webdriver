package com.seleniumsimplified.webdriver.drivers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;

public class HtmlUnitDriverTest {

    @Test

    public void driverIsKing() {

        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");

        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));

    }
}
