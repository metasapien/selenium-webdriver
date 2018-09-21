package com.seleniumsimplified.webdriver.basics.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InterrogationExerciseDOMfindElementByXPathTest {

    private static WebDriver driver;

    @BeforeClass

    public static void createDriverAndNavigateToPage(){
        driver = new ChromeDriver();
        //driver = Driver.get();
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void findByXPathId() {

        WebElement para1 = driver.findElement(By.xpath("//*[@id='p31']"));
        assertEquals(para1.getAttribute("name"), "pName31");

    }

    @Test
    public void findByXPathName() {

        WebElement name1 = driver.findElement(By.xpath("//*[@name='ulName1']"));
        assertEquals(name1.getAttribute("id"), "ul1");

    }

    @Test
    public void findByXPathTag() {

        WebElement name1 = driver.findElement(By.xpath("//li"));
        assertEquals(name1.getAttribute("name"), "liName1");

    }

    @Test
    public void findByXPathClassName() {

        WebElement className1 = driver.findElement(By.xpath("//*[@class='specialDiv']"));
        assertEquals(className1.getAttribute("id"), "div1");

    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}

