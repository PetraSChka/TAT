import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.LoginPage;
import Page.ProfilePage;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    public static WebDriverWait wait;

    String email="read.check.cool@gmail.com";
    String password="LOLOLOSHKA1";
    String name="artem";
    String phoneNumber="+375296319352";

    @BeforeClass
    public static void setup() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust&prevRID=K81RSH9PH61BJ8MS8758&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
        driver = null;
        wait = null;
    }

    @Test
    public void loginTest() throws InterruptedException {

        loginPage.inputEmail(email);
        Thread.sleep(2000);

        loginPage.clickLoginBtn();
        Thread.sleep(2000);

        loginPage.inputPassword(password);
        Thread.sleep(2000);

        loginPage.clickPasswordBtn();
        Thread.sleep(2000);

        //profilePage.entryMenu();
        //Thread.sleep(2000);

        //profilePage.entryUserMenu();

        //ИЗНАЧАЛЬНО Я ХОТЕЛ ПРОВЕРИТЬ ПО ПОЧТЕ И ТЕЛЕФОНУ ИЗ НАСТРОЕК
        //НО АМАЗОН НЕ ДАЁТ МНЕ ПО XPATH ВЗЯТЬ ЭТИ ДАННЫЕ
        String webName = profilePage.getName();;
       // String webEmail = profilePage.getEmail();
       // String webPhoneNumber = profilePage.getPhoneNumber();

        Assert.assertEquals("Hello, "+name, webName);
       // Assert.assertEquals(email, webEmail);
        //Assert.assertEquals(phoneNumber, webPhoneNumber);
    }
}
