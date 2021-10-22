package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationTest {

    @Test
    public void checkingNotificationsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement link = driver.findElement(By.xpath("//a[text()='Click here']"));
        link.click();
        String notificationMessage = driver.findElement(By.xpath("//div[@id=\"flash\"]")).getText();
        String successfulAction = "Action successful";
        String unsuccessfulAction = "Action unsuccessful, please try again";
        if (notificationMessage.equals(unsuccessfulAction)) {
            while (true) {
                link.click();
            }
        } else if (notificationMessage.equals(successfulAction)) {
            System.out.println("Your action was successful!");
        }
        driver.quit();
    }
}