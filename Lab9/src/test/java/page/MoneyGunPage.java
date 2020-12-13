package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoneyGunPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String MONEYGUN_URL = "https://www.amazon.com/Sopu-Money-Paper-Playing-Supplies/dp/B07MTXMRLH/ref=sr_1_1_sspa?dchild=1&keywords=money+gun&qid=1607865914&sr=8-1-spons&psc=1&spLa=ZW5jcnlwdGVkUXVhbGlmaWVyPUEzTkQzM1hIS0s4RU1WJmVuY3J5cHRlZElkPUEwMDI4NDE3N01NR1hTTEJIOEROJmVuY3J5cHRlZEFkSWQ9QTA1Mjc0MjYyRUhTUFM4S0FXT1BLJndpZGdldE5hbWU9c3BfYXRmJmFjdGlvbj1jbGlja1JlZGlyZWN0JmRvTm90TG9nQ2xpY2s9dHJ1ZQ==";
    private final By linkProductPriceLocator = By.id("priceblock_ourprice");
    private final By linkProductNameLocator = By.id("productTitle");

    @FindBy(id = "submit.add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(id = "nav-cart")
    private WebElement cartBtn;

    @FindBy(css = "[href*='/mysite']")
    private WebElement link;

    public MoneyGunPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MoneyGunPage openPage() {
        driver.navigate().to(MONEYGUN_URL);
        return this;
    }

    public String getName() {
        WebElement linkProductName = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkProductNameLocator));
        return linkProductName.getText();
    }

    public String getPrice() {
        WebElement linkProductPrice = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkProductPriceLocator));
        return linkProductPrice.getText();
    }

    public CartPage addProduct() {
        addToCartBtn.click();
        logger.info("Add to cart performed");
        cartBtn.click();
        return new CartPage(driver);
    }


}
