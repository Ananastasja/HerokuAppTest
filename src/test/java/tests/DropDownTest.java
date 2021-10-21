package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTest {

    @Test
    public void choosingElementFromDropDownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        String[] options = {"Please select an option", "Option 1", "Option 2"};
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//option"));
        for (int i = 0; i < options.length; i++) {
            Assert.assertEquals(options[i], dropDownOptions.get(i).getText());
        }
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        WebElement first_option = driver.findElement(By.xpath("//option[@value='1']"));
        dropDown.click();
        first_option.click();
        Assert.assertTrue(first_option.isSelected());
        WebElement second_option = driver.findElement(By.xpath("//option[@value='2']"));
        dropDown.click();
        second_option.click();
        Assert.assertTrue(second_option.isSelected());
        driver.quit();
    }
}
