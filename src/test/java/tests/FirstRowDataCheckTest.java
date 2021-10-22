package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstRowDataCheckTest {

    @Test
    public void comparingTableDataTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/tables");
        final String LAST_NAME = "Smith";
        final String FIRST_NAME = "John";
        final String EMAIL = "jsmith@gmail.com";
        final String SUM = "$50.00";
        final String WEBSITE = "http://www.jsmith.com";
        final String EDIT = "edit";
        final String DELETE = "delete";
        String firstCol = driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        Assert.assertEquals(LAST_NAME, firstCol);
        String secondCol = driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
        Assert.assertEquals(FIRST_NAME, secondCol);
        String thirdCol = driver.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
        Assert.assertEquals(EMAIL, thirdCol);
        String fourthCol = driver.findElement(By.xpath("//table//tr[1]//td[4]")).getText();
        Assert.assertEquals(SUM, fourthCol);
        String fifthCol = driver.findElement(By.xpath("//table//tr[1]//td[5]")).getText();
        Assert.assertEquals(WEBSITE,fifthCol);
        String sixthColEdit = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[6]/a[1]")).getText();
        Assert.assertEquals(EDIT,sixthColEdit);
        String sixthColDelete = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[6]/a[2]")).getText();
        Assert.assertEquals(DELETE, sixthColDelete);
        driver.quit();
    }
}
