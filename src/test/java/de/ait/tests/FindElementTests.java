package de.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class FindElementTests
{
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }

    @AfterMethod
        public void tearDown(){
        if (driver != null)
            driver.quit();

    }


    @Test
    public void findElementByTagName(){
        // find one element by tag name
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        //h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());
        //a
        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());
        System.out.println(link.getAttribute("class"));


        //find list of elements by tag name -> a
        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size());
        //labels
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());

    }
    @Test
    public void findElementById(){
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));


    }
    @Test
    public void findElementByClass(){
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getAttribute("class"));
        System.out.println(telephone.getText());

        WebElement container = driver.findElement(By.className("input-container"));
        System.out.println(container.getDomAttribute("class"));




    }
}
