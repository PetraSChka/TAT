package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "nav-link-accountList")
    private WebElement settingMenu;

    @FindBy(className = "ya-card__whole-card-link")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/div/span")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"cnep_1a_email_form\"]/div/div/div[1]/div[2]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"cnep_1a_mobile_phone_form\"]/div/div/div[1]/div[2]")
    private WebElement phoneNumber;

    public void entryMenu() {
        settingMenu.click();
    }

    public void entryUserMenu() {
        userMenu.click();
    }

    public String getName() {
        String webName = name.getText();
        return webName;
    }

    public String getEmail() {
        String webEmail = email.getText();
        return webEmail;
    }

    public String getPhoneNumber() {
        String webPhoneNumber = phoneNumber.getText();
        return webPhoneNumber;
    }

}


