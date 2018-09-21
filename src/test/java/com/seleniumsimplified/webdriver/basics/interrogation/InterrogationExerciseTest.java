package com.seleniumsimplified.webdriver.basics.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class InterrogationExerciseTest {

    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new ChromeDriver();
        //driver = Driver.get();
    }

    @Test
    public void driverLevelPageInterrogateMethods(){

        final String theTestPageURL = "http://www.compendiumdev.co.uk/selenium/basic_web_page.html";

        driver.navigate().to(theTestPageURL);

        assertEquals(driver.getTitle(), "Basic Web Page Title");
        assertThat(driver.getCurrentUrl(), is(theTestPageURL));
        assertTrue(driver.getPageSource().contains("A paragraph of text"));
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}

