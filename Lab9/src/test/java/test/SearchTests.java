package test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

import page.MainPage;
import util.CheckText;

public class SearchTests extends CommonConditions {

    private static final String NAME_OF_PRODUCT = "phone";

    @Test
    public void searchProductTest() {

        boolean chechName = true;
        List<WebElement> actualSearchElements = new MainPage(driver)
                .openPage()
                .searchInputText(NAME_OF_PRODUCT)
                .openSearchPage()
                .getNonFilterListElements();

        chechName = CheckText.wordVerification(actualSearchElements, chechName);

        Assert.assertFalse(chechName);
    }

    @Test
    public void filterProductTest() {
        boolean chechName = true;
        List<WebElement> actualSearchElements = new MainPage(driver)
                .openPage()
                .searchInputText(NAME_OF_PRODUCT)
                .openSearchPage()
                .getFilterListElements();

        chechName = CheckText.wordVerification(actualSearchElements, chechName);

        Assert.assertTrue(chechName);
    }
}