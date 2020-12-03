import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class AddToCart {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = new OperaDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
        wait = null;
    }

    @Test
    public void testAddToCart(){
        WebElement searchInput = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
        searchInput.sendKeys("money gun");

        WebElement searchBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\'nav-search-submit-text\']/input")));
        searchBtn.click();

        WebElement moneyGun = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/span/a")));
        moneyGun.click();

        WebElement addToCartBtn = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("submit.add-to-cart")));
        addToCartBtn.click();


        WebElement countItemInCart = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("nav-cart-count")));

        Assert.assertTrue(countItemInCart.getText().toLowerCase().contains("1"));
    }
}