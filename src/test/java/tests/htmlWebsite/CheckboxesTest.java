package tests.htmlWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {

    @Test
    public void ucheckingCheckboxTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        Assert.assertTrue(checkbox.isSelected());
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
        driver.quit();
    }
}