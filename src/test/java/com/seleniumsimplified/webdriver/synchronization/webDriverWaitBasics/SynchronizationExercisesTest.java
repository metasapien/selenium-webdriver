package com.seleniumsimplified.webdriver.synchronization.webDriverWaitBasics;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SynchronizationExercisesTest {

    static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/basic_ajax.html");

        wait = new WebDriverWait(driver,10);
    }


    @Test
    public void SelectDropdownItems(){

        //Default global implicit wait for all synchronization points
//        driver.manager().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement dropDown1Select;
        WebElement dropDown1Option;

        dropDown1Select = driver.findElement(By.id("combo1"));
        dropDown1Option = dropDown1Select.findElement(By.cssSelector("option[value='3']"));
        dropDown1Option.click();
// Explicit wait options
//        wait.until.until(invisibilityOfElementLocated(By.id("ajaxBusy")));
        wait.until(presenceOfElementLocated(By.cssSelector("option[value='23']")));
//        wait.until.until(visibilityOfElementLocated(By.cssSelector("option[value='23']")));
//        wait.until.until(elementToBeClickable(By.cssSelector("option[value='23']")));

        WebElement dropDown2Select;
        WebElement dropDown2Option;

        dropDown2Select = driver.findElement(By.id("combo2"));
        dropDown2Option = dropDown2Select.findElement(By.cssSelector("option[value='23']"));
        dropDown2Option.click();

        // local method
        clickSubmitButton();

        new WebDriverWait(driver,10).until(titleIs("Processed Form Details"));

        assertLanguageIDIsCorrect();

        driver.navigate().back();
        driver.navigate().refresh();

    }

    private void clickSubmitButton(){

        WebElement submitButton;
        submitButton = driver.findElement(By.cssSelector("input[type='submit'][name='submitbutton']"));
        submitButton.click();

    }

    private void assertLanguageIDIsCorrect(){

        WebElement dropDownResult;
        dropDownResult = driver.findElement(By.id("_valuelanguage_id"));
        assertEquals(dropDownResult.getText(), "23");

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

