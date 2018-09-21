package com.seleniumsimplified.webdriver.basics.manipulation.windows;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WindowsExercisesTest {

    private static WebDriver driver;

    // useful link on window/frame names http://www.webreference.com/js/tutorial1/names.html

    @BeforeClass
    public static void setup(){

        driver = new ChromeDriver();

    }

    @Test
    public void switchBetweenWindows(){

//        driver.quit(); // dodgy in a suite - close everything down and start again
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();

        String newWindowHandle=framesWindowHandle;

        // TODO: 20180611 this has a synchronisation error in Firefox since it works in debug mode
        Iterator<String> aHandle = driver.getWindowHandles().iterator();
        // forgot to add hasNext, could lead to an infinite loop
        while(newWindowHandle.equals(framesWindowHandle) && aHandle.hasNext()){
            newWindowHandle = aHandle.next();
        }

        driver.switchTo().window(newWindowHandle);

        // for Marionette Geckodriver need to switchTo defaultContent to check title
        driver.switchTo().defaultContent();
        // added to see if this fixes synch problem when run in suite
        new WebDriverWait(driver,5L).until(ExpectedConditions.titleContains("Selenium Simplified"));

        assertTrue("Expected Selenium Simplified site",
                driver.getTitle().contains("Selenium Simplified"));

        driver.switchTo().window(framesWindowHandle);

        // for Marionette Geckodriver need to switchTo defaultContent to check title
        //driver.switchTo().defaultContent();

        assertTrue("Expected Frames site",
                driver.getTitle().contains("Frameset Example"));

        driver.switchTo().window(newWindowHandle);
        driver.close();
        driver.switchTo().window(framesWindowHandle);

    }

    // This fails on IE
    @Test
    public void switchToByName(){

 //       driver.quit(); // dodgy in a suite - close everything down and start again
        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[id='goevil']")).click();

        // Firefox started failing here - need to sync on the linnk being available
        new WebDriverWait(driver,10).until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("a[target='compdev']")));

        // IE Fails at this point, suspect I need to change context back to allow a reclick
        driver.findElement(By.cssSelector("a[target='compdev']")).click();

        driver.switchTo().window("compdev");
        assertTrue("Expected Software Testing", driver.getTitle().contains("Software Testing"));

        // updated because my website title changed
        driver.switchTo().window("evil");
        assertTrue("Expected Evil Tester", driver.getTitle().contains("Evil Tester"));

        driver.switchTo().window(framesWindowHandle);
        assertTrue("Expected Frames site",
                driver.getTitle().contains("Frameset Example"));

        driver.switchTo().window("compdev");
        driver.close();
        assertEquals("Expected 2 windows left", 2, driver.getWindowHandles().size());

        // 20180611 Firefox has started failing here due to lost Browsing context
        driver.switchTo().window("evil");
        driver.close();
        assertEquals("Expected 1 window left", 1, driver.getWindowHandles().size());
    }

 /*   @AfterClass
    public static void cleanUp(){

        // I need to make sure that only one window open for other tests in CI
        driver.quit();
    }
*/
}
