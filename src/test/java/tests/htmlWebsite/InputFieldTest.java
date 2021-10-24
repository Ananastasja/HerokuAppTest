package tests.htmlWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputFieldTest {

    @Test
    public void checkingFieldVisibility() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement nameField = driver.findElement(By.className("name-field"));
        WebElement telField = driver.findElement(By.className("tel-field"));
        Assert.assertTrue(nameField.isDisplayed());
        Assert.assertTrue(telField.isDisplayed());
        driver.quit();
    }

    @Test
    public void enteringValidDataTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement nameField = driver.findElement(By.className("name-field"));
        WebElement telField = driver.findElement(By.className("tel-field"));
        nameField.sendKeys("Anastasia");
        telField.sendKeys("01570052241");
        Assert.assertEquals(nameField.getAttribute("value"), "Anastasia");
        Assert.assertEquals(telField.getAttribute("value"), "01570052241");
        driver.quit();
    }
}