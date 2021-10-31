package tests.htmlWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonTest {

    @Test
    public void findingAndClickingOnButtonTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement learnMoreButton = driver.findElement(By.id("learn-more-button"));
        Assert.assertTrue(learnMoreButton.isDisplayed());
        learnMoreButton.click();
        driver.quit();
    }@Test


    public void findingAndClickingOnButtonTest2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement submitButton = driver.findElement(By.id("submit-button"));
        Assert.assertTrue(submitButton.isDisplayed());
        submitButton.click();
        driver.quit();
    }
}
