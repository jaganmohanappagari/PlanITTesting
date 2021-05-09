package Steps;

import Pages.LoginPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class LoginSteps {
    @Page
    LoginPage loginPage;

    @Managed
    WebDriver driver;

    @Step
    public void clickOnLoginBtn() {
        loginPage.LoginLink.click();
    }

    @Step
    public void verifyWelcomeMsg(String sExpValue) {
        Assert.assertEquals(sExpValue,loginPage.welcomeMsg.getText());
    }

    @Step
    public void login_into_Tricentis_application(String email, String password) {
        loginPage.EmailTxt.sendKeys(email);
        loginPage.PasswordTxt.sendKeys(password);
        loginPage.LoginBtn.click();
    }
}
