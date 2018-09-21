package com.seleniumsimplified.junit;

import org.junit.jupiter.api.*;

/* This class uses jupiter.api libraries for junit, which are not compatible with mvn commandline test unr */

public class JUnitBeforeAndAfterTest {

    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Before test");
    }

    @Test
    public void this1Test() {
        System.out.println("This is 1 test");
    }

    @Test
    public void this2Test() {
        System.out.println("This is 2 test");
    }

    @Test
    public void this3Test() {
        System.out.println("This is 3 test");
    }

    @AfterEach
    public void afterTest(){
        System.out.println("After test");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("After class");
    }
}
