package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class FileDownloadPage extends BasePage {
    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    private static final String FILE_DOWNLOADER_URL = BASE_URL + "/download";

    public void openPage() {
        driver.get(FILE_DOWNLOADER_URL);
    }

    public List<WebElement> downloadElementList() {
        return driver.findElements(By.xpath("//*[@class='example']/a"));
    }

    public void downloadElementByIndex(int index) throws InterruptedException {
        downloadElementList().get(index).click();
        Thread.sleep(7000);
    }

    public File getLatestFileFromDir(){
        File dir = new File(System.getProperty("user.dir"));
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public String getExpectedLastFileName() {
        File getLatestFile = getLatestFileFromDir();
        String fileName = getLatestFile.getName();
        return fileName;
    }
}
