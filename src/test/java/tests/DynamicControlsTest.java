package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest{

    /* 1. Найти чекбокс
       2. Нажать на кнопку
       3. Дождаться надписи “It’s gone”
       4. Проверить, что чекбокса нет
       5. Найти инпут
       6. Проверить, что он disabled
       7. Нажать на кнопку
       8. Дождаться надписи “It's enabled!”
       9. Проверить, что инпут enabled */

    private final String EXPECTED_TEXT_UNDER_CHECKBOX = "It's gone!";
    private final String EXPECTED_TEXT_UNDER_INPUT = "It's enabled!";
    private final String REMOVE_BTN_NAME_AFTER_CLICK = "Add";
    private final String ENABLE_BTN_NAME_AFTER_CLICK = "Disable";

    @Test
    public void findCheckboxTest() {
        dynamicControlsPage.openPage();
        Assert.assertTrue(dynamicControlsPage.isCheckboxDisplayed());
    }

    @Test
    public void checkMessageUnderCheckboxTest() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.clickRemoveBtn();
        Assert.assertEquals(dynamicControlsPage.getTextAfterClick(), EXPECTED_TEXT_UNDER_CHECKBOX);
        Assert.assertEquals(dynamicControlsPage.getRemoveBtnName(), REMOVE_BTN_NAME_AFTER_CLICK);
    }

    @Test
    public void checkCheckboxNotDisplayedAfterRemoveBtnClickTest() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.clickRemoveBtn();
        Assert.assertTrue(dynamicControlsPage.isCheckboxHidden());
    }

    @Test
    public void checkInputIsDisplayedTest() {
        dynamicControlsPage.openPage();
        Assert.assertTrue(dynamicControlsPage.isInputDisplayed());
    }

    @Test
    public void checkInputIsDisabledTest() {
        dynamicControlsPage.openPage();
        Assert.assertFalse(dynamicControlsPage.isInputEnabled());
    }

    @Test
    public void checkMessageUnderInputTest() {
        dynamicControlsPage.openPage();
        dynamicControlsPage.clickEnableButton();
        Assert.assertEquals(dynamicControlsPage.getTextAfterClick(), EXPECTED_TEXT_UNDER_INPUT);
        Assert.assertEquals(dynamicControlsPage.getEnableBtnName(), ENABLE_BTN_NAME_AFTER_CLICK);
    }

    @Test
    public void checkInputIsEnabledTest() {
        dynamicControlsPage.openPage();
        Assert.assertFalse(dynamicControlsPage.isInputEnabled());
    }
}
