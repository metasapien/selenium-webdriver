package com.seleniumsimplified.webdriver.basics.manipulation.windows;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class WindowsExampleTest {

    private static WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public void quitToRestart(){

        // I need to make sure that only one window open so...
        driver.quit();

    }

    @Test
    public void switchToNewWindow() {

        // Current bug open with chrome driver
        // http://code.google.com/p/chromedriver/issues/detail?id=107

        driver.navigate().to(
                "http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();
        assertEquals("Expected only 1 current window", 1, driver.getWindowHandles().size());

        // Chrome bug workaround https://bugs.chromium.org/p/chromedriver/issues/detail?id=107#c36

        WebElement tmpFrame = null;
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        for (WebElement element : frames) {
            System.out.println(element.getAttribute("id") + "\t" + element.getAttribute("name"));
            if (element.getAttribute("name").equals("content")) {
                tmpFrame = element;
            }
        }

        // Chrome bug workaround ends

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();
        assertEquals("Expected a New Window opened", 2, driver.getWindowHandles().size());


        Set<String> myWindows = driver.getWindowHandles();
        String newWindowHandle = "";

        for (String aHandle : myWindows) {
            if (!framesWindowHandle.contentEquals(aHandle)) {
                newWindowHandle = aHandle;
                break;
            }
        }


        //      String newWindowHandle = framesWindowHandle;

        Iterator<String> aHandle = driver.getWindowHandles().iterator();
        while (newWindowHandle.equals(framesWindowHandle)) {
            newWindowHandle = aHandle.next();
        }

        driver.switchTo().window(newWindowHandle);
        wait.until(titleContains("Selenium Simplified"));

        // for Marionette Geckodriver need to switchTo defaultContent to check title
//        driver.switchTo().defaultContent();

        assertTrue("Expected Selenium Simplified site",
                driver.getTitle().contains("Selenium Simplified"));

        driver.switchTo().window(framesWindowHandle);

        assertTrue("Expected Frames site",
                driver.getTitle().contains("Frameset Example"));

        // Tidy up
        driver.switchTo().window(newWindowHandle);
        driver.close();
        driver.switchTo().window(framesWindowHandle);

    }

    @Test
    public void switchToByName(){

        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/frames");

        String framesWindowHandle = driver.getWindowHandle();

        // Chrome bug workaround https://bugs.chromium.org/p/chromedriver/issues/detail?id=107#c36

        WebElement tmpFrame = null;
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        for (WebElement element : frames) {
            System.out.println(element.getAttribute("id") + "\t" + element.getAttribute("name"));
            if (element.getAttribute("name").equals("content")) {
                tmpFrame = element;
            }
        }

        // Chrome bug workaround ends

        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("a[id='goevil']")).click();
        driver.findElement(By.cssSelector("a[target='compdev']")).click();

        driver.switchTo().window("compdev");
        assertTrue("Expected Software Testing", driver.getTitle().contains("Software Testing"));

        driver.switchTo().window("evil");
        assertTrue("Expected Evil Tester", driver.getTitle().contains("Evil Tester"));

        driver.switchTo().window(framesWindowHandle);
        assertTrue("Expected Frames Site", driver.getTitle().contains("Frameset Example"));

        driver.switchTo().window("compdev");
        driver.close();
        assertEquals("Expected 2 windows left", 2, driver.getWindowHandles().size());

    }

    @After
    public void quitToClean(){

        // I need to make sure that only one window open for other tests in CI
        driver.quit();
    }
}
