package com.seleniumsimplified.webdriver.basics.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InterrogationExerciseDOMfindElementByTest {

    private static WebDriver driver;

    @BeforeClass

    public static void createDriverAndNavigateToPage(){
        driver = new ChromeDriver();
        //driver = Driver.get();
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void findById() {

        WebElement para1 = driver.findElement(By.id("p1"));
        assertEquals(para1.getText(), "This is a paragraph text");

    }

    @Test
    public void findByName() {

        WebElement name1 = driver.findElement(By.name("pName5"));
        assertEquals(name1.getText(), "This is e paragraph text");

    }

    @Test
    public void findByLinkText() {

        WebElement linkText1 = driver.findElement(By.linkText("jump to para 0"));
        assertEquals(linkText1.getAttribute("id"), "a26");

    }

    @Test
    public void findByPartialLinkText() {

        WebElement partialLinkText1 = driver.findElement(By.partialLinkText("para 0"));
        assertEquals(partialLinkText1.getText(), "jump to para 0");

    }

    @Test
    public void findByClassName() {

        WebElement className1 = driver.findElement(By.className("specialDiv"));
        assertEquals(className1.getAttribute("id"), "div1");

    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}

