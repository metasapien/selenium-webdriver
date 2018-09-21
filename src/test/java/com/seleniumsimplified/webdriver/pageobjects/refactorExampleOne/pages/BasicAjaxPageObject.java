package com.seleniumsimplified.webdriver.pageobjects.refactorExampleOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasicAjaxPageObject {
    private static WebDriver driver;

    public enum Category {

        WEB(1), DESKTOP(2), SERVER(3);

        private int dropDownValue;

        Category (int value) {

            this.dropDownValue = value;
        }

        public enum Language {

            JAVA(1), JAVASCRIPT(2), CPP(3);

            private int dropDownValue;

            Language (int value) {

                this.dropDownValue = value;
            }

        public int value(){
            return dropDownValue;

        }
    }


    public BasicAjaxPageObject(WebDriver aDriver) {

        driver = aDriver;

    }

    public void get() {
        driver.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
    }

    public void selectCategory(Category category) {

        WebElement categorySelect = driver.findElement(By.id("combo1"));
        categorySelect.findElement(By.cssSelector("option[value='" + category.value() + "']")).click();


        // wait until the option I want to click is present
        // We could also wait for the contents of the drop down to fill

        //Instead wait for the ajax symbol

        // wait until the ajax symbol is gone

        new WebDriverWait(driver, 10).until(ajaxActionIsComplete());

    }

    public ExpectedCondition<Boolean> ajaxActionIsComplete() {
        return ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy"));
    }

    public void selectLanguage(int languageValue) {

        WebElement languageSelect = driver.findElement(By.id("combo2"));
        languageSelect.findElement(By.cssSelector("option[value='" + languageValue + "']")).click();
    }

    public void clickCodeInIt() {

        WebElement codeInIt = driver.findElement(By.name("submitbutton"));
        codeInIt.click();
    }

}