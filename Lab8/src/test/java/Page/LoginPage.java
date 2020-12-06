package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "ap_email")
    private WebElement loginField;

    @FindBy(id = "continue")
    private WebElement loginBtn;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement passwordBtn;

    public void inputEmail(String email) {
        loginField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void clickPasswordBtn() {
        passwordBtn.click();
    }
}
