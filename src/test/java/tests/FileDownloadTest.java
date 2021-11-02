package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {

    /* 1. Скачать файл
       2. Проверить наличие файла на файловой системе */

    private static final String DOWNLOAD_PATH = "C:/Users/nastu/Downloads";

    @Test
    //the path is chosen by default, mine is not applied (C:/) :( --> changed it to default
    public void downloadElementToPCTest() throws InterruptedException {
        fileDownloadPage.openPage();
        fileDownloadPage.downloadElement();
        Thread.sleep(7000);
    }

    @Test
    public void verifyDownloadedFileNameTest() {
        fileDownloadPage.getLatestFileFromDir(DOWNLOAD_PATH);
        fileDownloadPage.getExpectedLastFileName();
        Assert.assertEquals(fileDownloadPage.getExpectedLastFileName(), "evening (4).png");
    }
    //тут я намудрила, но работает хотя бы :D
}
