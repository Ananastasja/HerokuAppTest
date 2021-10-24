package tests.htmlWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PageContentTest {

    @Test
    public void checkingLogoTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement img = driver.findElement(By.xpath("//nav/img"));
        Assert.assertTrue(img.isDisplayed());
        driver.quit();
    }

    @Test
    public void checkingHeadingTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement heading = driver.findElement(By.tagName("h1"));
        String headingText = "STUNNING DESIGN PERFECT QUALITY.\n" + "GREAT PRICES.";
        Assert.assertEquals(heading.getText(),headingText);
        driver.quit();
    }

    @Test
    public void checkingNumberOfNaviLinksTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        List<WebElement> naviLinksList = driver.findElements(By.tagName("li"));
        Assert.assertEquals(naviLinksList.size(), 4);
        driver.quit();
    }


}