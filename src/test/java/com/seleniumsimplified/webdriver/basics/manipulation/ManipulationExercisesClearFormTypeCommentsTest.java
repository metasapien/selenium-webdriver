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

public class ManipulationExercisesClearFormTypeCommentsTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/basic_html_form.html");
    }

    @Test
    public void submitFormDefaultComments(){

        WebElement submitButton = driver.findElement(
                By.cssSelector("input[type='submit'][name='submitbutton']"));

        submitButton.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        WebElement commentsResults = driver.findElement(By.id("_valuecomments"));

        assertEquals(commentsResults.getText(), "Comments...");

        driver.navigate().back();
        driver.navigate().refresh();

    }

    @Test
    public void submitFormMyComments(){

        WebElement submitButton;
        WebElement commentTextArea;

       //Clear comments and enter new comments

        submitButton = driver.findElement(
                By.cssSelector("input[type='submit'][name='submitbutton']"));

        String myCommentString = "This is my comment";
        commentTextArea = driver.findElement(By.name("comments"));
        commentTextArea.clear();
        commentTextArea.sendKeys(myCommentString);

        submitButton.click();

        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));

        WebElement commentsResults = driver.findElement(By.id("_valuecomments"));

        assertEquals(commentsResults.getText(), myCommentString);

        driver.navigate().back();
        driver.navigate().refresh();

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}

