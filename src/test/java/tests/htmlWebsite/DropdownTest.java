package tests.htmlWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {

    @Test
    public void checkingOptionsInDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        String[] dropDownOptions = new String[]{"Select your gender", "Male", "Female"};
        List<WebElement> dropDown = driver.findElements(By.xpath("//option"));
        for (int i = 0; i < dropDownOptions.length; i++) {
            Assert.assertEquals(dropDown.get(i).getText(), dropDownOptions[i]);
        }
        driver.quit();
        //слабо представляю, как это можно сделать с foreach, было бы здорово посмотреть на реальном примере
    }

    @Test
    public void choosingOptionsInDropdown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        Select select = new Select(driver.findElement(By.id("gender")));
        select.selectByVisibleText("Male");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Male");
        driver.quit();
    }
}