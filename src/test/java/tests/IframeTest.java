package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest{

    /* 1. Открыть iFrame
       2. Проверить, что текст внутри параграфа равен “Your content goes here.” */

    private static final String EXPECTED_TEXT_IN_IFRAME = "Your content goes here.";

    @Test
    public void checkRightPageIsOpenedTest() {
        iframePage.openPage();
        Assert.assertTrue(iframePage.isTitleDisplayed());
    }

    @Test
    public void compareTextInIframeTest() {
        iframePage.openPage();
        Assert.assertEquals(iframePage.getTextFromIframeBox(), EXPECTED_TEXT_IN_IFRAME);
    }
}
