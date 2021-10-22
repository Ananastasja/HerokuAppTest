package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {

    @Test
    public void hoverOverElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions builder = new Actions(driver);
        WebElement img = driver.findElement(By.xpath("//div[@class='figure'][1]/img"));
        builder.moveToElement(img).build().perform();
        String expectedUserName = "name: user1";
        String userName = driver.findElement(By.xpath("//div[@class='figure'][1]/div/h5")).getText();
        Assert.assertEquals(expectedUserName,userName);
        WebElement linkViewProfile = driver.findElement(By.xpath("//div[@class='figure'][1]/div/a"));
        linkViewProfile.click();
        String error = "Not Found";
        if (driver.getPageSource().contains(error)) {
            System.out.println("There is a 404 error!");
        }else {
            System.out.println("Page is successfully opened!");
        }
        driver.quit();
        //не нашла решения, как сделать проверку каждого профиля через цикл. Сделала только на примере одного
    }
}