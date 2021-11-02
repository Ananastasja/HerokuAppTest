package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePage{
    public IframePage(WebDriver driver) {
        super(driver);
    }

    private static final String FRAME_URL = BASE_URL + "/frames";
    private static final By IFRAME_BTN = By.xpath("//a[contains(text(), 'iFrame')]");
    private static final By IFRAME_TITLE = By.xpath("//h3");
    private static final By IFRAME_BOX = By.id("mce_0_ifr");
    private static final By TEXT_BOX = By.xpath("//*[@id='tinymce']/p");

    public void openPage() {
        driver.get(FRAME_URL);
        driver.findElement(IFRAME_BTN).click();
    }

    public boolean isTitleDisplayed() {
        return driver.findElement(IFRAME_TITLE).isDisplayed();
    }

    public String getTextFromIframeBox() {
        driver.switchTo().frame(driver.findElement(IFRAME_BOX));
        return driver.findElement(TEXT_BOX).getText();
    }
}
