package de.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkFindByCss {
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
public void findElementByCssSelectorPartOne(){

    WebElement title = driver.findElement(By.cssSelector("h2"));
    System.out.println(title.getText());
    WebElement title2 = driver.findElement(By.cssSelector("h3"));
    System.out.println(title2.getText());
    //header-logo > a
    WebElement a = driver.findElement(By.cssSelector(".header-logo > a"));
    System.out.println(a.getText());
    // #poll-block-1 > ul > li:nth-child(1) > label
    WebElement label = driver.findElement(By.cssSelector("#poll-block-1 > ul > li:nth-child(1) > label"));
    System.out.println(label.getText());
    // div.block.block-category-navigation > div.title > strong
    WebElement strong = driver.findElement(By.cssSelector("div.block.block-category-navigation > div.title > strong"));
    System.out.println(strong.getText());





}
@Test
public void findElementByCssSelectorPartTwo(){
    WebElement flyoutCart = driver.findElement(By.cssSelector("#flyout-cart"));
    System.out.println(flyoutCart.getAttribute("id"));

    WebElement mobMene = driver.findElement(By.cssSelector("#mob-menu-button"));
    System.out.println(mobMene.getAttribute("id"));

    WebElement topCartLink = driver.findElement(By.cssSelector("#topcartlink"));
    System.out.println(topCartLink.getAttribute("id"));

    WebElement newsletter = driver.findElement(By.cssSelector("#newsletter-result-block"));
    System.out.println(newsletter.getAttribute("id"));

    WebElement pollBlock = driver.findElement(By.cssSelector("#poll-block-1"));
    System.out.println(pollBlock.getAttribute("id"));

}

@Test
    public void findElementByCssSelectorPartThree(){
   driver.findElement(By.cssSelector(".title"));
   driver.findElement(By.cssSelector(".inactive"));
   driver.findElement(By.cssSelector("[class*='listbox']"));
   driver.findElement(By.cssSelector(".tags"));
   driver.findElement(By.cssSelector(".picture > a"));




}
}
