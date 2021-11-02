package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage extends BasePage {
    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    private static final String DYNAMIC_CONTROLS_URL = BASE_URL + "/dynamic_controls";
    private static final By CHECKBOX_BTN = By.xpath("//*[@id=\"checkbox\"]/input");
    private static final By REMOVE_BTN = By.xpath("//*[@id=\"checkbox-example\"]/button");
    private static final By TEXT_AFTER_WAIT = By.xpath("//*[@id='message']");
    private static final By INPUT_FIELD = By.xpath("//*[@id=\"input-example\"]/input");
    private static final By ENABLE_BTN = By.xpath("//*[@id=\"input-example\"]/button");

    public void openPage() {
        driver.get(DYNAMIC_CONTROLS_URL);
    }

    public boolean isCheckboxDisplayed() {
        return driver.findElement(CHECKBOX_BTN).isDisplayed();
    }

    public void clickRemoveBtn() {
        driver.findElement(REMOVE_BTN).click();
        waitForElementLocated(TEXT_AFTER_WAIT, 5);
    }

    public String getRemoveBtnName() {
        return driver.findElement(REMOVE_BTN).getText();
    }

    public String getTextAfterClick() {
        return driver.findElement(TEXT_AFTER_WAIT).getText();
    }

    public boolean isCheckboxHidden() {
        return driver.findElements(CHECKBOX_BTN).size() < 1;
    }

    public boolean isInputDisplayed() {
        return driver.findElement(INPUT_FIELD).isDisplayed();
    }

    public boolean isInputEnabled() {
        return driver.findElement(INPUT_FIELD).isEnabled();
    }

    public void clickEnableButton() {
        driver.findElement(ENABLE_BTN).click();
        waitForElementLocated(TEXT_AFTER_WAIT, 5);
    }

    public String getEnableBtnName() {
        return driver.findElement(ENABLE_BTN).getText();
    }
}
