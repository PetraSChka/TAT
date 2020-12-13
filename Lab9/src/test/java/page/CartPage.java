package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractPage {

    private final String CART_URL = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
    private final By linkPriceProductLocator = By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span");

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

}