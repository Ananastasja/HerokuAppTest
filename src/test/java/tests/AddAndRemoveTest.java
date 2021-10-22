package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddAndRemoveTest {

    @Test
    public void addAndRemoveElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click();
        addButton.click();
        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//button[text()='Delete']"));
        int numberOfButtonsBeforeDeleting = deleteButtonList.size();
        Assert.assertEquals(numberOfButtonsBeforeDeleting, 2);
        driver.findElement(By.xpath("//button[@class = 'added-manually'][1]")).click();
        deleteButtonList = driver.findElements(By.xpath("//button[text()='Delete']"));
        int numberOfButtonsAfterDeleting = deleteButtonList.size();
        Assert.assertEquals(numberOfButtonsAfterDeleting, 1);
        driver.quit();
    }
}
