package test;

import model.User;
import page.LoginPage;
import service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserAccessTests extends CommonConditions {

    //Будем считать, что тест пройден - при запуске через браузер просит капчу
    @Test
    public void loginAmazon()
    {
        User devUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(devUser)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo("Hello, "+devUser.getName())));
    }
}
