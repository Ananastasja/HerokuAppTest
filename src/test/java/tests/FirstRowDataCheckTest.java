package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        String lastName = "Smith";
        String firstName = "John";
        String email = "jsmith@gmail.com";
        String sum = "$50.00";
        String website = "http://www.jsmith.com";
        String edit = "edit";
        String delete = "delete";
        String firstCol = driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        Assert.assertEquals(lastName, firstCol);
        String secondCol = driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
        Assert.assertEquals(firstName, secondCol);
        String thirdCol = driver.findElement(By.xpath("//table//tr[1]//td[3]")).getText();
        Assert.assertEquals(email, thirdCol);
        String fourthCol = driver.findElement(By.xpath("//table//tr[1]//td[4]")).getText();
        Assert.assertEquals(sum, fourthCol);
        String fifthCol = driver.findElement(By.xpath("//table//tr[1]//td[5]")).getText();
        Assert.assertEquals(website,fifthCol);
        String sixthColEdit = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[6]/a[1]")).getText();
        Assert.assertEquals(edit,sixthColEdit);
        String sixthColDelete = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[6]/a[2]")).getText();
        Assert.assertEquals(delete, sixthColDelete);
        driver.quit();
    }
}
