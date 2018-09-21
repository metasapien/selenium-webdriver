package com.seleniumsimplified.webdriver.basics.manipulation.frames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FramesExercisesRefactoredTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup(){

        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/frames/");

        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void switchToFramesTest(){

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        driver.switchTo().frame("menu");

        driver.findElement(By.cssSelector("a[href='frames_example_1.html']")).click();

        wait.until(titleIs("Frameset Example Title (Example 1)"));

    }

    @Test
    public void loadGreenPageTest(){

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        driver.switchTo().frame("content");

        driver.findElement(By.cssSelector("a[href='green.html']")).click();

        wait.until(presenceOfElementLocated(By.cssSelector("h1[id='green']")));

        driver.findElement(By.cssSelector("a[href='content.html']")).click();

        wait.until(titleIs("Frameset Example Title (Example 6)"));

        assertEquals("Content", driver.findElement(By.tagName("h1")).getText());

    }

    @Test
    public void clickiFramesExampleTest(){

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        driver.switchTo().frame("menu");

        driver.findElement(By.cssSelector("a[href='iframe.html']")).click();

 //       WebDriverWait wait=new WebDriverWait(driver, 20);

        wait.until(titleIs("HTML Frames Example - iFrame Contents"));

        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("a[href='frames_example_5.html']")).click();

        wait.until(titleIs("Frameset Example Title (Example 5)"));

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='index.html']")).click();

        wait.until(titleIs("Frameset Example Title (Example 6)"));

    }


    @After
    public void quitDriver(){

        driver.quit();

    }

}

