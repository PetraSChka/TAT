package page;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String CART_URL = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
    private final By linkPriceProductLocator = By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span");

    @FindBy(xpath = "//*[text()='Delete']")
    private WebElement deleteBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(CART_URL);
        return this;
    }

    public String getPrice(){
        WebElement linkPriceProduct = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(linkPriceProductLocator));
        return linkPriceProduct.getText();
    }

    public Boolean isProductOnCart(){
        By productLocator = By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span");
        try {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(productLocator));
        } catch (NoSuchElementException e) {
            logger.info("Элемент не найден");
            return false;
        }
        return true;
    }

    public CartPage deleteProduct() {
        deleteBtn.click();
        logger.info("Delete from cart performed");
        return new CartPage(driver);
    }

}