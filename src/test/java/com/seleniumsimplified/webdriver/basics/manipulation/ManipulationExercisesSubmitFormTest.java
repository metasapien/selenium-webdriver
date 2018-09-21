package com.seleniumsimplified.webdriver.basics.manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManipulationExercisesSubmitFormTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/basic_html_form.html");
    }

    @Test
    public void submitFormWithButtonClick(){

        WebElement submitButton = driver.findElement(
                By.cssSelector("input[type='submit'][name='submitbutton']"));

        submitButton.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        driver.navigate().back();
        driver.navigate().refresh();

    }

    @Test
    public void submitFormWithButtonSubmit(){

        WebElement submitButton = driver.findElement(
                By.cssSelector("input[type='submit'][name='submitbutton']"));

        submitButton.submit();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        driver.navigate().back();
        driver.navigate().refresh();

    }

    @Test
    public void submitFormWithFormSubmit(){

       WebElement submitForm = driver.findElement(
                By.id("HTMLFormElements"));

        submitForm.submit();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        driver.navigate().back();
        driver.navigate().refresh();
    }

    @Test
    public void iCanActuallySubmitOnAnyFormElement(){

        WebElement passwordInput = driver.findElement(
                By.cssSelector("input[type='password']"));

        passwordInput.submit();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        driver.navigate().back();
        driver.navigate().refresh();

    }

    @Test
    public void submitButtonWithKeyPress(){

        WebElement submitButton = driver.findElement(
                By.cssSelector("input[type='submit'][name='submitbutton']"));

        submitButton.sendKeys(Keys.SPACE);

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        driver.navigate().back();
        driver.navigate().refresh();

    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }

}

