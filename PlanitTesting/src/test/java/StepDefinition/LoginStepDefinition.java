package StepDefinition;

import Steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class LoginStepDefinition {

    @Managed
    WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Given("Launch the application")
    public void launch_the_application(List<Map<String,String>> values) {
        for(Map<String,String>value: values){
            String URL = StringUtils.defaultString(value.get("URL"));
            driver.manage().window().maximize();
            driver.get(URL);
        }
    }
    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        loginSteps.clickOnLoginBtn();
    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String sExpValue) {
        loginSteps.verifyWelcomeMsg(sExpValue);
    }

    @And("Login into Demo Web Shop Tricentis application")
    public void login_into_demo_web_shop_tricentis_application(List<Map<String,String>> values) {
        for(Map<String,String>value: values){
            String Email = StringUtils.defaultString(value.get("Email"));
            String Password = StringUtils.defaultString(value.get("Password"));
            loginSteps.login_into_Tricentis_application(Email,Password);
        }
    }

}
