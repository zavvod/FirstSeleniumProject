package de.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    // before - setUp
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
       // driver.get("https://google.com"); // like new user, without history
        driver.navigate().to("https://www.google.com/"); //like old user, with history
        driver.navigate().back(); //backspace
        driver.navigate().forward(); //forward
        driver.navigate().refresh(); //refresh



    }
    @Test
    public void openGoogle(){
        System.out.println("Google is opened");

    }


    // after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown(){
        //driver.quit(); //all tabs and browser are close
        driver.close(); //only current tab is close
        System.out.println("Browser Chrome is closed");

    }
}
