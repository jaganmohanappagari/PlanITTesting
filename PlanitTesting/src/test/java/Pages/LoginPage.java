package Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(id="Email")
    public WebElementFacade EmailTxt;

    @FindBy(id="Password")
    public WebElementFacade PasswordTxt;

    @FindBy(xpath="//a[text()='Log in']")
    public WebElementFacade LoginLink;

    @FindBy(xpath="//h1[.='Welcome, Please Sign In!']")
    public WebElementFacade welcomeMsg;

    @FindBy(xpath="//input[@value='Log in']")
    public WebElementFacade LoginBtn;


}
