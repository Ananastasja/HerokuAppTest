package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseTest {

    /* 1. Загрузить файл
       2. Проверить, что имя файла на странице совпадает с именем загруженного файла */

    private static final String EXPECTED_CONFIRMATION_MESSAGE = "File Uploaded!";
    private static final String EXPECTED_ERROR = "Internal Server Error";
    private static final String PATH_TO_FILE = "C:\\hello.png";
    private static final String UPLOADED_FILE_NAME = "hello.png";

    @Test
    public void uploadFileTest() {
        fileUploaderPage.openPage();
        fileUploaderPage.chooseFileFromDirectory(PATH_TO_FILE);
        fileUploaderPage.clickUploadBtnAndWaitForConfirmation();
        Assert.assertEquals(fileUploaderPage.getTextOnConfirmationPage(), EXPECTED_CONFIRMATION_MESSAGE);
        Assert.assertEquals(fileUploaderPage.getFileNameDisplayed(), UPLOADED_FILE_NAME);
    }

    @Test
    public void uploadWithoutFileChosenTest() {
        fileUploaderPage.openPage();
        fileUploaderPage.clickUploadBtnAndWaitForError();
        Assert.assertEquals(fileUploaderPage.getErrorMessage(), EXPECTED_ERROR);
    }
}
