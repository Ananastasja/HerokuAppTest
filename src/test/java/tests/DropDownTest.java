package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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
        WebElement firstOption = driver.findElement(By.xpath("//option[@value='1']"));
        dropDown.click();
        firstOption.click();
        Assert.assertTrue(firstOption.isSelected());
        WebElement secondOption = driver.findElement(By.xpath("//option[@value='2']"));
        dropDown.click();
        secondOption.click();
        Assert.assertTrue(secondOption.isSelected());
        driver.quit();
    }

    @Test
    public void choosingElementFromDropDownTest2() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 2");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 2");
        driver.quit();

    }
}