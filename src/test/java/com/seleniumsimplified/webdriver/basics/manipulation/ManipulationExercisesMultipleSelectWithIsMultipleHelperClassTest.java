package com.seleniumsimplified.webdriver.basics.manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManipulationExercisesMultipleSelectWithIsMultipleHelperClassTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/basic_html_form.html");
    }

    @Test
    public void selectSupportExpore(){

        WebElement multipleSelectElement;

        multipleSelectElement = driver.findElement(By.cssSelector("select[multiple='multiple']"));

        Select multipleSelect = new Select(multipleSelectElement);

        assertTrue(multipleSelect.isMultiple());

        List<WebElement> selectedElements = multipleSelect.getAllSelectedOptions();

        assertEquals(1, selectedElements.size());
        assertEquals("By default expected different item", "Selection item 4", selectedElements.get(0).getText());

        multipleSelect.deselectAll();

        assertEquals(0, selectedElements.size());

        multipleSelect.selectByVisibleText("Selection Item 1");
        multipleSelect.selectByIndex(1);
        multipleSelect.selectByValue("ms3");

        assertEquals( 3, selectedElements.size());


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

        assertEquals("ms1", driver.findElement((By.id("_valuemultipleselect0"))).getText(), "ms1");
        assertEquals("ms2", driver.findElement((By.id("_valuemultipleselect1"))).getText(), "ms2");
        assertEquals("ms3",driver.findElement((By.id("_valuemultipleselect2"))).getText(), "ms3");
        assertTrue(driver.findElements(By.id("_valuemultipleselect3")).isEmpty());

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

