package test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.Test;

import model.User;
import page.LoginPage;
import service.UserCreator;

public class UserAccessTests {

    @Test
    public void oneCanLoginGithub()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo(testUser.getEmail())));
    }
}