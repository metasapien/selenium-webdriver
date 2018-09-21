package com.seleniumsimplified.webdriver.basics.manipulation.frames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FramesExercisesTest {

    static WebDriver driver;

    @Before
    public void setup(){

        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/frames/");

    }

    @Test
    public void switchToFramesTest(){

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        driver.switchTo().frame("menu");

        driver.findElement(By.cssSelector("a[href='frames_example_1.html']")).click();

        String titleForExample1 = "Frameset Example Title (Example 1)";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals(titleForExample1, driver.getTitle());

        driver.navigate().back();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void loadGreenPageTest(){

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        driver.switchTo().frame("content");

        driver.findElement(By.cssSelector("a[href='green.html']")).click();

        String titleForGreenPage = "Green Page";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals(titleForGreenPage, driver.findElement(By.cssSelector("h1[id='green']")).getText());

        driver.findElement(By.cssSelector("a[href='content.html']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());
        assertEquals("Content", driver.findElement(By.tagName("h1")).getText());

    }

    @Test
    public void clickiFramesExampleTest(){

        assertEquals("Frameset Example Title (Example 6)",driver.getTitle());

        driver.switchTo().frame("menu");

        driver.findElement(By.cssSelector("a[href='iframe.html']")).click();

        WebDriverWait wait=new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.titleIs("HTML Frames Example - iFrame Contents"));

        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("a[href='frames_example_5.html']")).click();

        wait.until(ExpectedConditions.titleIs("Frameset Example Title (Example 5)"));

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='index.html']")).click();

        wait.until(ExpectedConditions.titleIs("Frameset Example Title (Example 6)"));

    }


    @After
    public void quitDriver(){

        driver.quit();

    }

}

