package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileDownloadPage extends BasePage {
    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    private static final String FILE_DOWNLOADER_URL = BASE_URL + "/download";
    //List<WebElement> downloadLinksList = driver.findElements(By.xpath("//*[@class=\"example\"]/a"));
    private static final By LINK_TO_DOWNLOAD = By.xpath("//a[contains(text(), 'evening')]");
    private static final String DOWNLOAD_PATH = "C:/Users/nastu/Downloads";


    public void openPage() {
        driver.get(FILE_DOWNLOADER_URL);
    }

   /* public void downloadElement() {
        WebElement downloadLink = downloadLinksList.get(2);
        downloadLink.click();
    }*/

    //don't understand why the size is 0 in error message as this is a List of elements

    public void downloadElement() {
        driver.findElement(LINK_TO_DOWNLOAD).click();
    }

    public File getLatestFileFromDir(String dirPath){
        File dir = new File(dirPath);
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
        File getLatestFile = getLatestFileFromDir(DOWNLOAD_PATH);
        String fileName = getLatestFile.getName();
        return fileName;
    }
}
