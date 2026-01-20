package de.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.swing.plaf.synth.SynthOptionPaneUI;
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

    @Test
    public void findElementByLinkText(){

        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());


        WebElement linkText2 = driver.findElement(By.linkText("Los Angeles"));
        System.out.println(linkText2.getText());


    }

    @Test
    public void findElementByPartialLinkText(){
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());


}
    @Test
    public void findElementByCssSelector(){


    // [key='value']
    // [href='/search']

        WebElement css1 = driver.findElement(By.cssSelector("[href='/search']"));
        WebElement css2 = driver.findElement(By.cssSelector("[for='city']"));

        //contains -> *
        driver.findElement(By.cssSelector("[class*='cities']"));
        // start -> ^
        driver.findElement(By.cssSelector("[class^='top']"));
        // end -> $
        driver.findElement(By.cssSelector("[class$='container']"));

        //composite cssSelector
        //tag+class+pare

        WebElement aSearch = driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));
        System.out.println(aSearch.getText());


       // WebElement xPath1 = driver.findElement(By.xpath(("//*[@id='0']")));
       // System.out.println(xPath1.getText());
        //one step below
        WebElement logoImg = driver.findElement(By.cssSelector(".logo>img"));
        // one or more steps below -- space
        driver.findElement(By.cssSelector(".feedback-body .feedback-date"));


        //<tag> or <class> or <id>:nth-child(n)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback:nth-child(1)"));
        System.out.println(feedback.getText());

        WebElement login = driver.findElement(By.cssSelector(".navigation-link:nth-child(6)"));
        System.out.println(login.getText());





    }




}


