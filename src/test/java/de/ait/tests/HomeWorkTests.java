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

public class HomeWorkTests {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
    @Test
    public void findElementByTagName(){



        WebElement title = driver.findElement(By.tagName("h2"));
        System.out.println(title.getText());

        WebElement title2 = driver.findElement(By.tagName("h3"));
        System.out.println(title2.getText());

        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());

        List<WebElement> strong = driver.findElements(By.tagName("strong"));
        System.out.println(strong.size());


    }
    @Test
    public void findElementById(){
        WebElement flyoutCart = driver.findElement(By.id("flyout-cart"));
        System.out.println(flyoutCart.getAttribute("id"));

        WebElement mobMene = driver.findElement(By.id("mob-menu-button"));
        System.out.println(mobMene.getAttribute("id"));

        WebElement topCartLink = driver.findElement(By.id("topcartlink"));
        System.out.println(topCartLink.getAttribute("id"));

        WebElement newsletter = driver.findElement(By.id("newsletter-result-block"));
        System.out.println(newsletter.getAttribute("id"));

        WebElement pollBlock = driver.findElement(By.id("poll-block-1"));
        System.out.println(pollBlock.getAttribute("id"));



    }

    @Test
    public void findElementByClass(){
        WebElement title = driver.findElement(By.className("title"));
        System.out.println(title.getAttribute("class"));

        WebElement inactive = driver.findElement(By.className("inactive"));
        System.out.println(inactive.getAttribute("class"));

        WebElement listbox = driver.findElement(By.className("listbox"));
        System.out.println(listbox.getAttribute("class"));

        WebElement tags = driver.findElement(By.className("tags"));
        System.out.println(tags.getAttribute("class"));

        WebElement picture = driver.findElement(By.className("picture"));
        System.out.println(picture.getAttribute("class"));





    }
}
