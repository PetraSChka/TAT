package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.LoginPage;
import page.MoneyGunPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CartTests extends CommonConditions {

   @Test
    public void AddToCart() {

        String priceOfProduct = new MoneyGunPage(driver)
                .openPage()
                .getPrice();

        String priceOfProductInCart = new MoneyGunPage(driver)
                .openPage()
                .addProduct()
                .getPrice();

        assertThat(priceOfProductInCart, is(equalTo(priceOfProduct)));
    }

    @Test
    public void DeleteFromCart() {
        Boolean priceOfProductInCart = new MoneyGunPage(driver)
                .openPage()
                .addProduct()
                .deleteProduct()
                .isProductOnCart();

        Assert.assertTrue(priceOfProductInCart);
    }
}
