package test;

import page.SettingPage;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SettingTests extends CommonConditions {

    @Test
    public void changeCurrency() {
        String currency = new SettingPage(driver)
                .openPage()
                .changeCurrency()
                .getCurrency();

        assertThat(currency, is(equalTo("RUB - Russian Ruble")));
    }
}
