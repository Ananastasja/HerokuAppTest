package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TyposTest {

    @Test
    public void checkParagraphSpellingTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/typos");
        String firstTextToCompare = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
        String firstParagraphElement = driver.findElement(By.xpath("//p[1]")).getText();
        Assert.assertEquals(firstParagraphElement, firstParagraphElement);
        String secondTextToCompare = "Sometimes you'll see a typo, other times you won't.";
        String secondParagraphElement = driver.findElement(By.xpath("//p[2]")).getText();
        if (secondTextToCompare.equals(secondParagraphElement)){
            System.out.println("There are no typos");
        }else {
            System.out.println("There is a typo! Please correct it.");
        }
        driver.quit();
    }
}
