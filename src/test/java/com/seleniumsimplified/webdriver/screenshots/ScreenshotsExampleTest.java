package com.seleniumsimplified.webdriver.screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;



public class ScreenshotsExampleTest {

    @Test
    public void gotoPage() throws IOException {

        WebDriver driver = new FirefoxDriver();

        driver.get("http://seleniumsimplified.com");

        TakesScreenshot snapper = (TakesScreenshot)driver;

        File tempScreenshot = snapper.getScreenshotAs(OutputType.FILE);

        System.out.println(tempScreenshot.getAbsolutePath());

        File myScreenshotDirectory = new File("C:\\temp\\screenshots\\");
        myScreenshotDirectory.mkdirs();

        File myScreenshot = new File(myScreenshotDirectory, "gotoPageScreen.png");
        if(myScreenshot.exists()){
            FileUtils.deleteQuietly(myScreenshot);
        }

        FileUtils.moveFile(tempScreenshot, myScreenshot);

        assertTrue(myScreenshot.length()>0);

        driver.get("file://" + myScreenshot.getAbsolutePath());

    }

}
