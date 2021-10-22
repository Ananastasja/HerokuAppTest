package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTest {

    @Test
    public void inputFieldAndArrowsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("1111");
        String textFromField = inputField.getAttribute("value");
        Assert.assertEquals(textFromField, "1111");
        for (int i = 100; i >= 0; i--) {
            inputField.sendKeys(Keys.DOWN);
            int expectedNumber = 1111;
            String expectedString = String.valueOf(expectedNumber);
            Assert.assertEquals(textFromField, expectedString);
            expectedNumber--;
        }
        inputField.clear();
        inputField.sendKeys("1011");
        textFromField = inputField.getAttribute("value");
        for (int i = 0; i <= 100; i++) {
            inputField.sendKeys(Keys.UP);
            int expectedNumber = 1011;
            String expectedString = String.valueOf(expectedNumber);
            Assert.assertEquals(textFromField, expectedString);
            expectedNumber++;
        }
        driver.quit();
    }
}
