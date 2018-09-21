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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManipulationExercisesMultipleSelectTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/basic_html_form.html");
    }

    @Test
    public void submitFormWithMultiSelect123SelectedFindElements(){

        WebElement multiSelect;
        WebElement dropDownOption;

        multiSelect = driver.findElement(By.cssSelector("select[multiple='multiple']"));
        List<WebElement> multiSelectOptions = multiSelect.findElements(By.tagName("option"));

        multiSelectOptions.get(0).click();
        multiSelectOptions.get(1).click();
        multiSelectOptions.get(2).click();

        if(multiSelectOptions.get(3).isSelected()){
            multiSelectOptions.get(3).click();
        }

        // local method
        clickSubmitButton();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertMultiSelectResults();

        driver.navigate().back();
        driver.navigate().refresh();

    }

    private void clickSubmitButton(){

        WebElement submitButton;
        submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));
        submitButton.click();

    }

    private void assertMultiSelectResults(){

        assertEquals(driver.findElement((By.id("_valuemultipleselect0"))).getText(), "ms1");
        assertEquals(driver.findElement((By.id("_valuemultipleselect1"))).getText(), "ms2");
        assertEquals(driver.findElement((By.id("_valuemultipleselect2"))).getText(), "ms3");
        assertTrue(driver.findElements(By.id("_valuemultipleselect3")).isEmpty());

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

