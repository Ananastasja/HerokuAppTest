package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage extends BasePage{

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    private static final String CONTEXT_MENU_URL = BASE_URL + "/context_menu";

    public void openPage() {
        driver.get(CONTEXT_MENU_URL);
    }

    public void waitForAlertDisplayed(int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void clickTheContextMenu() {
        Actions actions = new Actions(driver);
        WebElement rightClickBox = driver.findElement(By.id("hot-spot"));
        actions.contextClick(rightClickBox).perform();
        waitForAlertDisplayed(5);
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}
