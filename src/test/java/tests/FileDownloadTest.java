package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {

    /* 1. Скачать файл
       2. Проверить наличие файла на файловой системе */

    @Test
    public void downloadElementToPCTest() throws InterruptedException {
        fileDownloadPage.openPage();
        fileDownloadPage.downloadElementByIndex(2);
        Assert.assertEquals(fileDownloadPage.getExpectedLastFileName(), "evening (4).png");
    }
}
