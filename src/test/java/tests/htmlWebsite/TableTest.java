package tests.htmlWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {

    @Test
    public void findingRowNumberInTableTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        WebElement websiteTable = driver.findElement(By.tagName("table"));
        List<WebElement> rowNumber = websiteTable.findElements(By.tagName("tr"));
        Assert.assertEquals(rowNumber.size(), 4);
        driver.quit();
    }

    @Test
    public void readingTableDataTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("C:\\HerokuApp\\src\\test\\java\\html_package\\index.html");
        final String expectedFirstElement = "Whole flat design";
        final String expectedSecondElement = "2-4 days";
        final String expectedThirdElement = "750 Euros";
        WebElement firstElement = driver.findElement(By.xpath("//tr[@id='firstRow']/td[1]"));
        WebElement secondElement = driver.findElement(By.xpath("//tr[@id='firstRow']/td[2]"));
        WebElement thirdElement = driver.findElement(By.xpath("//tr[@id='firstRow']/td[3]"));
        Assert.assertEquals(firstElement.getText(), expectedFirstElement);
        Assert.assertEquals(secondElement.getText(), expectedSecondElement);
        Assert.assertEquals(thirdElement.getText(), expectedThirdElement);
        driver.quit();
    }
}