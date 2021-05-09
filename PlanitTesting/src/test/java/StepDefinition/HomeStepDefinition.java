package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import Steps.HomeSteps;

import java.util.List;
import java.util.Map;


public class HomeStepDefinition {

    @Managed
    WebDriver driver;

    @Steps
    HomeSteps homeSteps;

    @Then("{string} should be displayed in home page")
    public void should_be_displayed_in_home_page(String sEmail) {
        homeSteps.verifyAccountInfoInHomepage(sEmail);
    }

    @When("user click on Shopping cart")
    public void user_click_on_shopping_cart() throws InterruptedException {
        homeSteps.clickOnShoppingCart();
    }

    @When("clear the shopping cart")
    public void clear_the_shopping_cart() {
        homeSteps.clearShoppingCart();
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String sExpMsg) {
        homeSteps.verifyShoppingCartEmptyMsg(sExpMsg);
    }

    @When("Navigate to Books menu item from categories")
    public void navigate_to_books_menu_item_from_categories() {
        homeSteps.NavigateToBooksMenuItemFromCategory();
    }

    @When("Select book from the list")
    public void select_book_from_the_list() {
        homeSteps.SelectBookFromList();
    }
    @When("get the price details")
    public void get_the_price_details() {
        homeSteps.getPriceDetails();
    }
    @When("Enter the quantity as {string}")
    public void enter_the_quantity_as(String sQty) {
        homeSteps.EnterQuantity(sQty);
    }
    @When("click on the Add to cart")
    public void click_on_the_add_to_cart() {
        homeSteps.clickAddToCart();
    }
    @Then("{string} notification message should be displayed")
    public void notification_message_should_be_displayed(String sMsg) {
        homeSteps.verifyNotificationMsg(sMsg);
    }

    @Then("verify the sub total price of the selected item")
    public void verify_the_sub_total_price_of_the_selected_item() {
        homeSteps.verifySubTotalPrice();
    }

    @Then("click on check out button")
    public void click_on_check_out_button() {
        homeSteps.clickOnCheckOut();
    }

    @When("user Selct the billing address as {string}")
    public void user_selct_the_billing_address_as(String sAddress) {
        homeSteps.SelectBillingAddress(sAddress);
    }

    @When("Enter the below details")
    public void enter_the_below_details(List<Map<String,String>> values) throws InterruptedException {
        for(Map<String,String>value: values){
            String Country = StringUtils.defaultString(value.get("Country"));
            String City = StringUtils.defaultString(value.get("City"));
            String Address1 = StringUtils.defaultString(value.get("Address1"));
            String Zip_PostalCode = StringUtils.defaultString(value.get("Zip_PostalCode"));
            String PhoneNumber = StringUtils.defaultString(value.get("PhoneNumber"));
            homeSteps.EnterBillingDetails(Country,City,Address1,Zip_PostalCode,PhoneNumber);
        }

    }

    @When("Select the Shipping address as billing address")
    public void select_the_shipping_address_as_billing_address(List<Map<String,String>> values) throws InterruptedException {
        for(Map<String,String>value: values){
            String shippingAddress = StringUtils.defaultString(value.get("Billing_Address"));
            homeSteps.EnterShippingAddress(shippingAddress);
        }
    }

    @When("Select the shipping method as {string}")
    public void select_the_shipping_method_as(String shippingMethodType) throws InterruptedException {
        homeSteps.SelectShippingMethodType(shippingMethodType);
    }

    @When("choose payment method as {string}")
    public void choose_payment_method_as(String paymentMethodType) throws InterruptedException {
        homeSteps.selectPaymentMethod(paymentMethodType);
    }

    @Then("{string} message in payment info")
    public void message_in_payment_info(String sMessage) {
        homeSteps.verifyCODMessageInPaymentInfoSection(sMessage);
    }

    @Then("click on Payment info section")
    public void click_on_payment_info_section() throws InterruptedException {
        homeSteps.ClickOnPaymentInfo();
    }

    @Then("click on Confirm order")
    public void click_on_confirm_order() throws InterruptedException {
        homeSteps.clickOnConfirmOrder();
    }
    @Then("{string} Confirm order message should be displayed")
    public void confirm_order_message_should_be_displayed(String sConfrimOrderMsg) {
        homeSteps.verifyConfirmOrderMsg(sConfrimOrderMsg);
    }
    @Then("Get The Order number")
    public void get_the_order_number() {
        homeSteps.getTheOrderNumber();
    }

    @Then("click on Continue order")
    public void click_on_continue_order() {
        homeSteps.clickOnContinueOrder();
    }

    @Then("user click on Log out of the application")
    public void user_click_on_log_out_of_the_application() {
        homeSteps.LogoutOftheApplication();
    }






}
