package test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

import page.MainPage;

public class SearchTests extends CommonConditions {

    @Test
    public void searchProductTest() {
        List<WebElement> actualSearchElements = new MainPage(driver)
                .openPage()
                .searchInputText("money gun")
                .openSearchPage()
                .getListElements();
        Assert.assertFalse(actualSearchElements.isEmpty());
    }
}