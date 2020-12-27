package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://amazon.com/";
    private final By linkLoggedInNameLocator = By.xpath("//*[@id=\"nav-link-accountList\"]/div/span");
    private final By searchFieldLocator = By.id("twotabsearchtextbox");

    @FindBy(xpath = "//*[@id=\"nav-search\"]/form/div[3]")
    private WebElement searchButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MainPage searchInputText(String text) {
        WebElement searchField = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchFieldLocator));
        searchField.sendKeys(text);
        return this;
    }

    public SearchPage openSearchPage() {
        searchButton.click();
        return new SearchPage(driver);
    }

    public String getLoggedInUserName() {
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkLoggedInNameLocator));
        return linkLoggedInUser.getText();
    }
}