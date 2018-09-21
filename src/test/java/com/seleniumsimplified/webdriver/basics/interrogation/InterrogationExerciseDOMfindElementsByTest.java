package com.seleniumsimplified.webdriver.basics.interrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InterrogationExerciseDOMfindElementsByTest {

    private static WebDriver driver;

    @BeforeClass

    public static void createDriverAndNavigateToPage(){
        driver = new ChromeDriver();
        //driver = Driver.get();
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/find_by_playground.php");
    }

    @Test
    public void assertDivElementsCount() {

        List<WebElement> elements;
        elements = driver.findElements(By.tagName("div"));

        assertEquals(19,elements.size());

    }

    @Test
    public void assertInternalHrefElementsCount() {

        List<WebElement> elements;
        elements = driver.findElements(By.partialLinkText("jump to para"));

        assertEquals(25,elements.size());

    }

    @Test
    public void assertNumberOfParagraphs() {

        List<WebElement> elements;
        elements = driver.findElements(By.tagName("p"));

        int nestedCount = 0;
        for(WebElement e : elements){
            if(e.getText().contains("nested para")){
                nestedCount++;
            }
        }
        assertEquals(41,elements.size());
        assertEquals(16,nestedCount);

    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}

