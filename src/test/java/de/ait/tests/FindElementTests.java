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

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/search");

        //maximize browser to window
        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findElementByTagName() {
        //find one element by tagName -> h1
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        //h2
        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());
        //a(logo)
        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());
        System.out.println(link.getAttribute("class"));

        //find list of elements by tag name -> a
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        //labels
        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {

        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement container = driver.findElement(By.className("input-container"));
        System.out.println(container.getDomAttribute("class"));
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());

        WebElement linkText2 = driver.findElement(By.linkText("Los Angeles"));
        System.out.println(linkText2.getText());
    }

    @Test
    public void findElementPartialLinkText() {
        WebElement partialText = driver.findElement(By.partialLinkText("car work"));
        System.out.println(partialText.getText());

    }

    @Test
    public void findElementByCssSelector() {
        // driver.findElement(By.tagName("h1"));
        // tag name "h1" -> css "h1"
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("h2"));

        // driver.findElement(By.id("city"));
        // id "city" -> css "#city"
        driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.cssSelector("#dates"));

        // driver.findElement(By.className("telephone"));
        // class "telephone" -> css ".telephone"
        driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.cssSelector(".input-container"));

        // [key='value']
        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='city']"));

        //contains -> *
        driver.findElement(By.cssSelector("[class*='cities']"));
        //start -> ^
        driver.findElement(By.cssSelector("[class^='top']"));
        //end to -> $
        driver.findElement(By.cssSelector("[class$='container']"));

        //composite cssSelector
        //tag+class+pare
        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));
        //one step below --  >
        driver.findElement(By.cssSelector(".logo>img"));
        //one or more steps below -- space
        driver.findElement(By.cssSelector(".feedback-body .feedback-date"));

        //<tag> or <class> or <id>:nth-child(n)
        WebElement feedback = driver.findElement(By.cssSelector(".feedback:nth-child(1)"));
        System.out.println(feedback.getText());
        WebElement logIN = driver.findElement(By.cssSelector(".navigation-link:nth-child(6)"));
        System.out.println(logIN.getText());
    }

    @Test
    public void findElementByXpath() {
        //     //tag[@arrtibute='value']
        //     //tag[1]
        //     //tag[@arrtibute='value1' and  @arrtibute='value2'] // and, or
        //     //tag[@arrtibute='value1' or  @arrtibute='value2']
        //     //tag[text()='Text']
        //     //tag[contains(text(),'partial text')]

        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//h2"));

        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//input[@id='city']"));
        driver.findElement(By.xpath("//input[@id='dates']"));


        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//a[@class='telephone']"));
        driver.findElement(By.xpath("//div[@class='input-container']"));

        //driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.xpath("//a[@href='/search']"));
        driver.findElement(By.xpath("//label[@for='city']"));

        //driver.findElement(By.cssSelector("[class^='top']"));
        driver.findElement(By.xpath("//*[starts-with(@class,'top')]"));

        //driver.findElement(By.cssSelector("[class*='cities']"));
        driver.findElement(By.xpath("//*[contains(@class,'cities')]"));

        //text Our car was modern

        //driver.findElement(By.xpath("//*[contains(text()='Our car was modern']"));
        driver.findElement(By.xpath("//*[contains(.,'Our car was modern')]"));

        //driver.findElement(By.xpath(//span[()=' Latest feedback from our customers ']));

        //driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));
        driver.findElement(By.xpath("//a[@class='navigation-link' and @href='/search']"));

        //driver.findElement(By.cssSelector(".logo>img"));
        driver.findElement(By.xpath("//a[@class='logo']/img"));

        //driver.findElement(By.cssSelector(".feedback-body .feedback-date"));
        driver.findElement(By.xpath("//div[@class='feedback-body']//span[@class='feedback-date']"));

        //driver.findElement(By.cssSelector(".feedback:nth-child(1)"));




    }

    @Test
    public void findElementByXpathFamily(){
        //parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));

        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*"));
        driver.findElement(By.xpath("//h1/ancestor::div"));
        driver.findElement(By.xpath("//h1/ancestor::div[1]"));//one step

        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::h2"));

        //preceding-sibling // //h2/preceding-sibling::h1
        driver.findElement(By.xpath("//h2/preceding-sibling::h1"));









    }

}
