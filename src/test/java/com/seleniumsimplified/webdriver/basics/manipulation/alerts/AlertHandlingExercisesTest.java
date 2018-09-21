package com.seleniumsimplified.webdriver.basics.manipulation.alerts;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class AlertHandlingExercisesTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/alerts.html");

    }

    @Test
    public void basicAlertHandlingAcceptTest(){

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage,driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        driver.navigate().refresh();

    }

    @Test
    public void basicAlertHandlingDismissTest(){

        WebElement alertButton;

        alertButton = driver.findElement(By.id("alertexamples"));

        alertButton.click();

        String alertMessage = "I am an alert box!";

        assertEquals(alertMessage,driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        driver.navigate().refresh();

    }

    @Test
    public void basicConfirmHandlingAcceptTest(){

        WebElement confirmButton;
        WebElement confirmResult;

        confirmButton = driver.findElement(By.id("confirmexample"));
        confirmResult = driver.findElement(By.id("confirmreturn"));

        assertEquals("cret", confirmResult.getText());

        confirmButton.click();

        String alertMessage = "I am a confirm alert";

        Alert confirmAlert = driver.switchTo().alert();

        assertEquals(alertMessage,confirmAlert.getText());

        confirmAlert.accept();

        assertEquals("true", confirmResult.getText());

        driver.navigate().refresh();

    }

    @Test
    public void basicConfirmHandlingDismissTest(){

        WebElement confirmButton;
        WebElement confirmResult;

        confirmButton = driver.findElement(By.id("confirmexample"));
        confirmResult = driver.findElement(By.id("confirmreturn"));

        assertEquals("cret", confirmResult.getText());

        confirmButton.click();

        String alertMessage = "I am a confirm alert";

        Alert confirmAlert = driver.switchTo().alert();

        assertEquals(alertMessage,confirmAlert.getText());

        confirmAlert.dismiss();

        assertEquals("false", confirmResult.getText());

        driver.navigate().refresh();

    }

    @Test
    public void basicPromptHandlingAcceptTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());

        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        assertEquals(alertMessage,promptAlert.getText());

        promptAlert.accept();

        assertEquals("change me", promptResult.getText());

        driver.navigate().refresh();

    }

    @Test
    public void basicPromptHandlingDismissTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());

        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        assertEquals(alertMessage,promptAlert.getText());

        promptAlert.dismiss();

        assertEquals("pret", promptResult.getText());

        driver.navigate().refresh();

    }

    @Test
    public void basicPromptHandlingChangeAndAcceptTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());

        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        assertEquals(alertMessage,promptAlert.getText());

        promptAlert.sendKeys("Hello");
        promptAlert.accept();

        assertEquals("Hello", promptResult.getText());

        driver.navigate().refresh();

    }

    @Test
    public void basicPromptHandlingChangeAndDismissTest(){

        WebElement promptButton;
        WebElement promptResult;

        promptButton = driver.findElement(By.id("promptexample"));
        promptResult = driver.findElement(By.id("promptreturn"));

        assertEquals("pret", promptResult.getText());

        promptButton.click();

        String alertMessage = "I prompt you";

        Alert promptAlert = driver.switchTo().alert();

        assertEquals(alertMessage,promptAlert.getText());

        promptAlert.sendKeys("Hello");
        promptAlert.dismiss();

        assertEquals("pret", promptResult.getText());

        driver.navigate().refresh();

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

