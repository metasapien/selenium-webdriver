package com.seleniumsimplified.webdriver.userinteractions;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class UserInteractionsExercisesTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){

        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk" +
                "/selenium/gui_user_interactions.html");

    }

    @Before
    public void resetPage(){
        driver.navigate().refresh();

    }

    @Test
    public void moveDraggable1ToDroppable1(){
        WebElement draggable1 = driver.findElement(By.id("draggable1"));
        WebElement droppable1 = driver.findElement(By.id("droppable1"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable1).moveToElement(droppable1).release().perform();

        assertEquals("Dropped!", droppable1.getText());

    }

    @Test
    public void dragAndDropDraggable2ToDroppable1(){
        WebElement draggable2 = driver.findElement(By.id("draggable2"));
        WebElement droppable1 = driver.findElement(By.id("droppable1"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable2,droppable1).perform();

        assertEquals("Get Off Me!", droppable1.getText());

    }


    @Test
    public void controlAndSpace(){
        /*
            when I press control+space the red squares say "Let GO!!"
            we can't check this
         */
        WebElement droppable1 = driver.findElement(By.id("droppable1"));

        Actions actions = new Actions(driver);
        actions.click(droppable1).build().perform();
        // sendkeys does a keydown followed by keyup, so you can't use it for this
        // as keys need to be held down
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.SPACE).build().perform();
        String dropText = droppable1.getText();
        actions.keyUp(droppable1,Keys.CONTROL).build().perform();

        try{
            assertEquals("Let GO!!", dropText);
            fail("send keys should not be held down long enough to get the text");
        }catch(ComparisonFailure e){
            assertTrue("How can we hold down the keys?",true);
            assertEquals("Drop Here", dropText);
        }
    }


    @Test
    public void controlAndBwaHaHa(){
        /* when we issue a control+ B draggable 1 says "Bwa! Ha! Ha! */

        WebElement draggable1 = driver.findElement(By.id("draggable1"));

        Actions actions = new Actions(driver);

        draggable1.click();

        new Actions(driver).keyDown(Keys.CONTROL).
                sendKeys("b").
                keyUp(Keys.CONTROL).
                perform();

        assertEquals("Bwa! Ha! Ha!", draggable1.getText());

        // firefox used to fail on this when it did a keyup after every keyDown
    }

    @Test
    public void drawSomethingOnCanvas(){
        WebElement canvas = driver.findElement(By.id("canvas"));
        WebElement eventList = driver.findElement(By.id("keyeventslist"));

        int eventCount = eventList.findElements(By.tagName("li")).size();

        new Actions(driver).
                // click doesn't do it, need to click and hold
                //click(canvas).
                        clickAndHold(canvas).
                moveByOffset(10,10).
                release().
                perform();

        assertTrue("we should have had some draw events",
                eventCount < eventList.findElements(By.tagName("li")).size());

    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();

    }
}
