package com.seleniumsimplified.webdriver.basics.manipulation.alerts;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AlertHandlingExampleTest {

    private static WebDriver driver;

    @Before
    public void setup(){

        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/alert.html");

    }

    @Test
    public void basicAlertHandlingExample(){

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage,driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

