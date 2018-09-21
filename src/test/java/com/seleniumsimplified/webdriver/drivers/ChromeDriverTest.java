package com.seleniumsimplified.webdriver.drivers;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class ChromeDriverTest {

    @Test

    public void driverIsKing() {

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");

        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));

    }
}
