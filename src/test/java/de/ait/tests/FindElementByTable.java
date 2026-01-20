package de.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.SocketImpl;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

public class FindElementByTable {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }

    @AfterMethod
    public void tearDown(){
        if (driver != null)
            driver.quit();

    }

    @Test
    public void tableCssSelector(){

        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (int i = 0; i <rows.size() ; i++) {
            System.out.println(rows.get(i).getText());

        }
        System.out.println("------------------------------");

       for (WebElement element: rows){
           System.out.println(element.getText());
       }
        System.out.println("********************************");



       //get row 2
        WebElement germany = driver.findElement(By.cssSelector("#customers tr:nth-child(2)"));
        System.out.println(germany.getText());
        System.out.println("********************************");

        //get row 2, element 2
        WebElement germany2 = driver.findElement(By.cssSelector("#customers tr:nth-child(2) td:nth-child(2)"));
        System.out.println(germany2.getText());
        System.out.println("********************************");

        //get row 2, last element
        WebElement germany3 = driver.findElement(By.cssSelector("#customers tr:nth-child(2) td:last-child"));
        System.out.println(germany3.getText());
        System.out.println("********************************");




    }
}
