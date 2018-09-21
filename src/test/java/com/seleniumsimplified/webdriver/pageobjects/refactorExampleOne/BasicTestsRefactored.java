package com.seleniumsimplified.webdriver.pageobjects.refactorExampleOne;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.pageobjects.refactorExampleOne.pages.BasicAjaxPageObject;
import com.seleniumsimplified.webdriver.pageobjects.refactorExampleOne.pages.BasicAjaxPageObject.Category;
import com.seleniumsimplified.webdriver.pageobjects.refactorExampleOne.pages.ProcessedFormPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static com.seleniumsimplified.webdriver.pageobjects.refactorExampleOneExercise.pages.BasicAjaxPageObject.Category;
import static com.seleniumsimplified.webdriver.pageobjects.refactorExampleOneExercise.pages.BasicAjaxPageObject.Language;


public class BasicTestsRefactored {

        private static WebDriver driver;
        private BasicAjaxPageObject basicAjaxPage;

        // This has local abstractions instead of page objects
        // We want to refactor this to page objects

        // All these tests do pretty much the same thing so we will change when we refactor

        @BeforeClass
        public static void setupTestClass() throws MalformedURLException {
            driver = Driver.get();

        }

        @AfterClass
        public static void tearDown(){
            driver.quit();
        }
        @Before
        public void setupTest() throws MalformedURLException {

            basicAjaxPage = new BasicAjaxPageObject(driver);
            basicAjaxPage.get();

        }

        @Test
        public void chooseToCodeInJavaOnTheServerFromCombosSyncOnAjaxBusyExample(){


            basicAjaxPage.selectCategory(Category.SERVER);

            basicAjaxPage.selectLanguage(23);
            basicAjaxPage.clickCodeInIt();

            ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
            processedFormPage.waitUntilPageIsLoaded();

            assertEquals("Expected Java code", "23",processedFormPage.getValueFor("language_id"));


        }

        @Test
        public void chooseToCodeInJavascriptOnTheWeb(){

            // Force WEB selection to be active, rather than passive/default by first selecting SERVER

            basicAjaxPage.selectCategory(Category.SERVER);

            basicAjaxPage.selectCategory(Category.WEB);

            // then select Java
            basicAjaxPage.selectLanguage(0);

            basicAjaxPage.clickCodeInIt();

            ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
            processedFormPage.waitUntilPageIsLoaded();

            assertEquals("Expected Javascript code", "0",processedFormPage.getValueFor("language_id"));

        }

        @Test
        public void chooseToCodeInCppOnTheDesktop(){

            basicAjaxPage.selectCategory(Category.DESKTOP);

            // then select Java
            basicAjaxPage.selectLanguage(10);

            basicAjaxPage.clickCodeInIt();

            ProcessedFormPage processedFormPage = new ProcessedFormPage(driver);
            processedFormPage.waitUntilPageIsLoaded();

            assertEquals("Expected C++ code", "10",processedFormPage.getValueFor("language_id"));

        }

 }
