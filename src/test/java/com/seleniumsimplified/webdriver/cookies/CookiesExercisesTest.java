package com.seleniumsimplified.webdriver.cookies;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CookiesExercisesTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        // driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/search.php");
    }

    @Test
    public void submitSearchTest(){

        driver.manage().deleteAllCookies();

        driver.navigate().refresh();

/*        Cookie aCookie = new Cookie.Builder(aCookie.getName(), String.valueOf()).
                            domain(aCookie.getDomain()).
                            path(aCookie.getPath()).
                            expiresOn(aCookie.getExpiry()).isSecure(aCookie.isSecure()).
                            build();
*/
        Cookie searchNumVisitsCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");

        int searchNumVisits = Integer.parseInt(searchNumVisitsCookie.getValue());

        assertEquals(1, searchNumVisits);

        WebElement submitButton;
        WebElement searchTextArea;

        //Clear comments and enter new comments

        submitButton = driver.findElement(
                By.cssSelector("input[type='submit']"));

        String mySearchString = "Java";
        searchTextArea = driver.findElement(By.cssSelector("input[title='Search']"));
        searchTextArea.clear();
        searchTextArea.sendKeys(mySearchString);

        submitButton.click();

        Cookie lastSearchCookie = driver.manage().getCookieNamed("seleniumSimplifiedLastSearch");

        assertEquals("Java", lastSearchCookie.getValue());

        // This doesn't work - figure out why!
//        int newSearchNumVisits = Integer.parseInt(searchNumVisitsCookie.getValue());

//        assertEquals(2, newSearchNumVisits);

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }

}
