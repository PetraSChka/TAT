package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends AbstractPage {
    private final By productLocator = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

    @FindBy(xpath = "//li[@id='p_89/Samsung Electronics']//i")
    private WebElement brandFilterButton;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SearchPage openPage() {
        throw new RuntimeException("This page can't be open without parameters");
    }

    public List<WebElement> getNonFilterListElements() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(productLocator));
    }

    public List<WebElement> getFilterListElements() {
        brandFilterButton.click();
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(productLocator));
    }
}
