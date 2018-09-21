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

public class ManipulationExercisesDropDown5SelectedTest {

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

        WebElement dropDownSelect;
        WebElement dropDownOption;

        dropDownSelect = driver.findElement(By.cssSelector("select[name='dropdown']"));
        dropDownOption = dropDownSelect.findElement(By.cssSelector("option[value='dd5']"));
        dropDownOption.click();

        // local method
        clickSubmitButton();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        assertDropDownValueIsCorrect();

        driver.navigate().back();
        driver.navigate().refresh();

    }

    private void clickSubmitButton(){

        WebElement submitButton;
        submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));
        submitButton.click();

    }

    private void assertDropDownValueIsCorrect(){

        WebElement dropDownResult;
        dropDownResult = driver.findElement(By.id("_valuedropdown"));
        assertEquals(dropDownResult.getText(), "dd5");

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

