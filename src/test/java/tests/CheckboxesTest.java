package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {

    @Test
    public void checkingAndUncheckingCheckboxesTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox_1 = driver.findElement(By.xpath("//input[1]"));
        Assert.assertFalse(checkbox_1.isSelected());
        checkbox_1.click();
        Assert.assertTrue(checkbox_1.isSelected());
        WebElement checkbox_2 = driver.findElement(By.xpath("//input[2]"));
        Assert.assertEquals(checkbox_2.isSelected(), true);
        checkbox_2.click();
        Assert.assertEquals(checkbox_2.isSelected(), false);
        driver.quit();
    }
}