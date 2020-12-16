package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String CART_URL = "https://www.amazon.com/gp/customer-preferences/select-language/ref=topnav_lang_ais?preferencesReturnUrl=%2F";
    private final By linklinkCurrencyLocator = By.id("a-autoid-0-announce");

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement saveChangesBtn;

    @FindBy(id = "a-autoid-0-announce")
    private WebElement dropList;

    @FindBy(id = "icp-sc-dropdown_53")
    private WebElement valueRub;

    public SettingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public SettingPage openPage() {
        driver.navigate().to(CART_URL);
        return this;
    }

    public String getCurrency (){
        WebElement linkCurrency = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linklinkCurrencyLocator));
        return linkCurrency.getText();
    }

    public SettingPage changeCurrency() {
        dropList.click();
        valueRub.click();
        saveChangesBtn.click();
        logger.info("Currency changes performed");
        return new SettingPage(driver);
    }




}
