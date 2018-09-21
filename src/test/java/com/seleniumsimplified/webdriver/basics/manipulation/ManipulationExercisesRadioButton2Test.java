package com.seleniumsimplified.webdriver.basics.manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManipulationExercisesRadioButton2Test {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/basic_html_form.html");
    }

    @Test
    public void submitFormWithOnlyRadioButton2SelectedFindElementException(){

        WebElement radioButton2;

        radioButton2 = driver.findElement(By.cssSelector("input[type='radio'][value='rd2']"));

        if(!radioButton2.isSelected()){
            radioButton2.click();
        }

        WebElement submitButton;

        submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));

        submitButton.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        WebElement radioButtonResult;

        radioButtonResult = driver.findElement(By.id("_valueradioval"));

        assertEquals(radioButtonResult.getText(), "rd2");

        driver.navigate().back();
      driver.navigate().refresh();

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

