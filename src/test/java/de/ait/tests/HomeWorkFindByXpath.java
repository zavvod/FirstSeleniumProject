package de.ait.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomeWorkFindByXpath {
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
    public void findElementByXpathPartOne() {
        // h2 -> //h2
        WebElement title = driver.findElement(By.xpath("//h2"));
        System.out.println(title.getText());
        // h3 -> //h3
        WebElement title2 = driver.findElement(By.xpath("//h3"));
        System.out.println(title2.getText());
        // .header-logo > a -> //*[@class='header-logo']/a
        WebElement a = driver.findElement(By.xpath("//*[@class='header-logo']/a"));
        System.out.println(a.getText());
        // #poll-block-1 > ul > li:nth-child(1) > label
        // -> //*[@id='poll-block-1']/ul/li[1]/label
        WebElement label = driver.findElement(By.xpath("//*[@id='poll-block-1']/ul/li[1]/label"));
        System.out.println(label.getText());
        // div.block.block-category-navigation > div.title > strong
        // Используем contains(@class, ...) для надежности
        WebElement strong = driver.findElement(By.xpath("//div[contains(@class,'block-category-navigation')]//div[contains(@class,'title')]/strong"));
        System.out.println(strong.getText());
    }
    @Test
    public void findElementByXpathPartTwo() {
        // #flyout-cart -> //*[@id='flyout-cart']
        WebElement flyoutCart = driver.findElement(By.xpath("//*[@id='flyout-cart']"));
        System.out.println(flyoutCart.getAttribute("id"));
        // #mob-menu-button -> //*[@id='mob-menu-button']
        WebElement mobMenu = driver.findElement(By.xpath("//*[@id='mob-menu-button']"));
        System.out.println(mobMenu.getAttribute("id"));
        // #topcartlink -> //*[@id='topcartlink']
        WebElement topCartLink = driver.findElement(By.xpath("//*[@id='topcartlink']"));
        System.out.println(topCartLink.getAttribute("id"));
        // #newsletter-result-block -> //*[@id='newsletter-result-block']
        WebElement newsletter = driver.findElement(By.xpath("//*[@id='newsletter-result-block']"));
        System.out.println(newsletter.getAttribute("id"));
        // #poll-block-1 -> //*[@id='poll-block-1']
        WebElement pollBlock = driver.findElement(By.xpath("//*[@id='poll-block-1']"));
        System.out.println(pollBlock.getAttribute("id"));
    }
    @Test
    public void findElementByXpathPartThree() {
        // .title -> //*[contains(@class,'title')]
        driver.findElement(By.xpath("//*[contains(@class,'title')]"));
        // .inactive -> //*[contains(@class,'inactive')]
        driver.findElement(By.xpath("//*[contains(@class,'inactive')]"));
        // [class*='listbox'] -> //*[contains(@class,'listbox')]
        driver.findElement(By.xpath("//*[contains(@class,'listbox')]"));
        // .tags -> //*[contains(@class,'tags')]
        driver.findElement(By.xpath("//*[contains(@class,'tags')]"));
        // .picture > a -> //*[contains(@class,'picture')]/a
        driver.findElement(By.xpath("//*[contains(@class,'picture')]/a"));
    }
}

