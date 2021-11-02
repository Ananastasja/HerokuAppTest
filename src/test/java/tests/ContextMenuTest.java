package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    /* 1. Правый клик по элементу
       2. Валидация текста на алерте
       3. Закрытие алерта */

    private static final String TEXT_ON_ALERT = "You selected a context menu";

    @Test
    public void checkTextOnAlertTest() {
        contextMenuPage.openPage();
        contextMenuPage.clickTheContextMenu();
        Assert.assertEquals(contextMenuPage.getAlertText(), TEXT_ON_ALERT);
    }

    @Test
    public void closeAlertTest() {
        contextMenuPage.openPage();
        contextMenuPage.clickTheContextMenu();
        contextMenuPage.closeAlert();
        //don't know what kind of assert I could place here
        //or I can just combine these two tests
    }
}
