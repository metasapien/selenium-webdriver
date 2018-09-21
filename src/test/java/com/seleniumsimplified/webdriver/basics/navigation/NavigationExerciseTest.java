package com.seleniumsimplified.webdriver.basics.navigation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


public class NavigationExerciseTest {

    private static WebDriver driver;

    @BeforeClass
    public static void createDriver(){
        driver = new FirefoxDriver();
        //driver = Driver.get();
    }

    @Test
    public void navigateWithNavigateToSelenium(){
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium");
        assertTrue(driver.getTitle().
                startsWith("Selenium Simplified"));
    }

    @Test
    public void navigateWithNavigateToSearch(){
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/search.php");
        assertTrue(driver.getTitle().
                startsWith("Selenium Simplified Search Engine"));

        driver.navigate().back();
        assertTrue(driver.getTitle().
                startsWith("Selenium Simplified"));

        driver.navigate().forward();
        assertTrue(driver.getTitle().
                startsWith("Selenium Simplified Search Engine"));
    }

    @Test
    public void navigateWithNavigateToForm(){
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
        assertTrue(driver.getTitle().
                startsWith("HTML Form Elements"));
    }

    @Test
    public void navigateWithNavigateToPage(){
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/basic_web_page.html");
        assertTrue(driver.getTitle().
                startsWith("Basic Web Page Title"));

        driver.navigate().back();
        assertTrue(driver.getTitle().
                startsWith("HTML Form Elements"));

        driver.navigate().forward();
        assertTrue(driver.getTitle().
                startsWith("Basic Web Page Title"));
    }

    @Test
    public void navigateWithNavigateToRefresh(){
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/refresh.php");
        assertTrue(driver.getTitle().
              startsWith("Refreshed Page on"));
    }

    @AfterClass
    public static void quitDriver(){
       // driver.quit();
    }
}

