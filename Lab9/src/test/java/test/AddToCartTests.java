package test;

import model.User;
import org.testng.annotations.Test;
import page.CartPage;
import page.LoginPage;
import page.MoneyGunPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AddToCartTests extends CommonConditions {

   @Test
    public void CheckProductByPrice() {

        String priceOfProduct = new MoneyGunPage(driver)
                .openPage()
                .getPrice();

        String priceOfProductInCart = new MoneyGunPage(driver)
                .openPage()
                .addProduct()
                .getPrice();

        assertThat(priceOfProductInCart, is(priceOfProduct));
    }
}
