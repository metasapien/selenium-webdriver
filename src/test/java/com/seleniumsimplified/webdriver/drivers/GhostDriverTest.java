/* package com.seleniumsimplified.webdriver.drivers;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GhostDriverTest {

    public static final File PHANTOM_JS = new File(System.getProperty("user.dir"), "C:/Program Files/phantomjs-2.1.1-windows/bin/phantomjs.exe");

    @Before
    public static void checkDependencies(){
        assertEquals(PHANTOM_JS.exists(), "true");
    }
    @Test

    public void driverIsKing() {

        WebDriver driver = new PhantomJSDriver();

        driver.get("http://www.compendiumdev.co.uk/selenium");

        assertTrue(driver.getTitle().startsWith("Selenium Simplified"));

    }
}*/
