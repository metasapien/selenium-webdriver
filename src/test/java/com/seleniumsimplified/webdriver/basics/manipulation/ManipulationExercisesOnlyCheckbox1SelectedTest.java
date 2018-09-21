package com.seleniumsimplified.webdriver.basics.manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManipulationExercisesOnlyCheckbox1SelectedTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/basic_html_form.html");
    }

    @Test
    public void submitFormWithOnlyCheckbox1SelectedFindElementException(){

        WebElement checkBox1;
        checkBox1 = driver.findElement(By.cssSelector("input[type='checkbox'][value='cb1']"));
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        WebElement checkBox2;
        checkBox2 = driver.findElement(By.cssSelector("input[type='checkbox'][value='cb2']"));
        if(checkBox2.isSelected()){
            checkBox2.click();
        }

        WebElement checkBox3;
        checkBox3 = driver.findElement(By.cssSelector("input[type='checkbox'][value='cb3']"));
        if(checkBox3.isSelected()){
            checkBox3.click();
        }
        // local method
        clickSubmitButton();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertCheckBoxResults();

        driver.navigate().back();
        driver.navigate().refresh();

    }

    private void clickSubmitButton(){

        WebElement submitButton;
        submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));
        submitButton.click();

    }

    private void assertCheckBoxResults(){

        WebElement checkBox1Result;
        checkBox1Result = driver.findElement(By.id("_valuecheckboxes0"));
        assertEquals(checkBox1Result.getText(), "cb1");

        WebElement checkBox2Result=null;
        try {
            checkBox2Result = driver.findElement(By.id("_valuecheckboxes1"));
        }catch(NoSuchElementException e){
            //expected missing element
        }
        assertTrue(checkBox2Result==null);

        WebElement checkBox3Result=null;
        try {
            checkBox3Result = driver.findElement(By.id("_valuecheckboxes2"));
        }catch(NoSuchElementException e){
            // expected missing element
        }
        assertTrue(checkBox2Result==null);

    };

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

