package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePage {
    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    //how to do drag and drop from PC to website?

    private static final String FILE_UPLOADER_URL = BASE_URL + "/upload";
    private static final By FILE_UPLOAD_FIELD = By.id("file-upload");
    private static final By FILE_UPLOAD_BTN = By.id("file-submit");
    //private static final By DRAG_DROP_UPLOAD_BOX = By.id("drag-drop-upload");
    private static final By UPLOAD_CONFIRMATION_TEXT = By.xpath("//h3");
    private static final By UPLOAD_ERROR = By.xpath("//h1");
    private static final By UPLOAD_FILE_NAME = By.id("uploaded-files");

    public void openPage() {
        driver.get(FILE_UPLOADER_URL);
    }

    public void chooseFileFromDirectory(String path) {
        driver.findElement(FILE_UPLOAD_FIELD).sendKeys(path);
    }

    public void clickUploadBtnAndWaitForConfirmation() {
        driver.findElement(FILE_UPLOAD_BTN).click();
        waitForElementLocated(UPLOAD_CONFIRMATION_TEXT, 5);
    }

    public void clickUploadBtnAndWaitForError() {
        driver.findElement(FILE_UPLOAD_BTN).click();
        waitForElementLocated(UPLOAD_ERROR, 5);
    }

    public String getTextOnConfirmationPage() {
        return driver.findElement(UPLOAD_CONFIRMATION_TEXT).getText();
    }

    public String getFileNameDisplayed() {
        return driver.findElement(UPLOAD_FILE_NAME).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(UPLOAD_ERROR).getText();
    }
}


