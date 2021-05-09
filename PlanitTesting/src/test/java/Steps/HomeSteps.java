package Steps;

import Pages.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomeSteps {

    @Page
    HomePage homePage;

    @Managed
    WebDriver driver;
    public static double DPrice;
    public static String sPrice;
    public static String sQty;

    @Step
    public void verifyAccountInfoInHomepage(String sEmail) {
        Assert.assertEquals(sEmail,homePage.accountId.getText());
    }

    @Step
    public void clickOnShoppingCart() throws InterruptedException {
        Thread.sleep(8000);
        homePage.shoppingCart.click();
    }

    @Step
    public void clearShoppingCart() {
        int iItemsCount = getDriver().findElements(By.xpath("//table[@class='cart']/tbody/tr")).size();
        if(iItemsCount >= 1){
            for(int i = 1; i <= iItemsCount; i++){
                getDriver().findElement(By.xpath("//table[@class='cart']/tbody/tr["+i+"]//input[@type='checkbox']")).click();
            }
            homePage.updatecart.click();
        }
    }

    @Step
    public void verifyShoppingCartEmptyMsg(String sExpMsg) {
        Assert.assertEquals(sExpMsg,homePage.ShoppingCartEmpty.getText());
    }

    @Step
    public void NavigateToBooksMenuItemFromCategory() {
        homePage.BooksMenuItem.click();
    }

    @Step
    public void SelectBookFromList() {
        homePage.productItem.click();
    }
    @Step
    public void getPriceDetails() {
        sPrice = homePage.price.getText().trim();
        System.out.println("Book price :- "+sPrice);
        DPrice = Double.parseDouble (sPrice);
    }

    @Step
    public void EnterQuantity(String sQtyValue) {
        sQty = sQtyValue;
        homePage.Qty.clear();
        homePage.Qty.sendKeys(sQty);
    }

    @Step
    public void clickAddToCart() {
        homePage.AddToCart.click();
    }
    @Step
    public void verifyNotificationMsg(String sMsg) {
        Assert.assertEquals(sMsg,homePage.NotificationMsg.getText());
    }

    public void SelectItemFromDropDown(WebElement element, String sOptionValue){
        Select select = new Select(element);
        select.selectByVisibleText(sOptionValue);
    }

    @Step
    public void verifySubTotalPrice() {
        String sActualSubTotalPrice = homePage.SubTotalPrice.getText();
        double dExpectedSubTotalPrice = (int)DPrice * Integer.parseInt(sQty);
        String sExpectedSubTotalPrice = ""+String.format("%.2f", dExpectedSubTotalPrice);
        Assert.assertEquals(sExpectedSubTotalPrice,sActualSubTotalPrice);
    }

    @Step
    public void clickOnCheckOut() {
        homePage.TermsOfConditionCheckbox.click();
        homePage.checkout.click();
    }

    @Step
    public void SelectBillingAddress(String sAddress) {
        SelectItemFromDropDown(homePage.BillingAddressCmb,sAddress);
    }

    @Step
    public void EnterBillingDetails(String country, String city, String address1, String zip_postalCode, String phoneNumber) throws InterruptedException {
        SelectItemFromDropDown(homePage.BillingCountryCmb,country);
        homePage.BillingNewAddress_CityTxt.sendKeys(city);
        homePage.BillingNewAddress_Address1.sendKeys(address1);
        homePage.BillingNewAddress_ZipPostalCodeTxt.sendKeys(zip_postalCode);
        homePage.BillingNewAddress_PhoneNumberTxt.sendKeys(phoneNumber);
        homePage.billing_ContinueBtn.click();

        WaitUntilLoadNextStep("billingDetails");
        Thread.sleep(5000);
    }

    //wait untill load next step
    private void WaitUntilLoadNextStep(String sSectionName) throws InterruptedException {
        String id = "";
        switch (sSectionName){
            case "billingDetails":
                id = "opc-billing";
                break;
            case "shippingDetails":
                id = "opc-shipping";
                break;
            case "shipping_methodDetails":
                id = "opc-shipping_method";
                break;
            case "payment_methodDetails":
                id = "opc-payment_method";
                break;
            case "payment_infoDetails":
                id = "opc-payment_info";
                break;
            case "confirm_orderDetails":
                id = "opc-confirm_order";
                break;
            default:
        }
        for(int i = 1; i <= 10; i++){
            if(!getDriver().findElement(By.id(id)).getAttribute("class").contains("active")){
                Thread.sleep(12000);
                break;
            }
        }
    }

    @Step
    public void EnterShippingAddress(String shippingAddress) throws InterruptedException {
        SelectItemFromDropDown(homePage.shippingAddressCmb,shippingAddress);
        homePage.shipping_ContinueBtn.click();
        WaitUntilLoadNextStep("shippingDetails");
    }

    @Step
    public void SelectShippingMethodType(String shippingMethodType) throws InterruptedException {
        switch (shippingMethodType){
            case "Ground":
                break;
            case "Next Day Air":
                homePage.shipping_Method_NextDayAirOpt.click();
                break;
            case "2nd Day Air":
                break;
            default:
        }
        homePage.shipping_Method_ContinueBtn.click();
        WaitUntilLoadNextStep("shipping_methodDetails");
    }

    @Step
    public void selectPaymentMethod(String paymentMethodType) throws InterruptedException {
        switch (paymentMethodType){
            case "Cash On Delivery":
                homePage.paymentCODOpt.click();
                break;
            case "Check / Money Order":
                break;
            case "Credit Card":
                break;
            case "Purchase Order":
                break;
            default:
        }
        homePage.payment_Method_ContinueBtn.click();
        WaitUntilLoadNextStep("payment_methodDetails");
    }

    @Step
    public void verifyCODMessageInPaymentInfoSection(String sMessage) {
        Assert.assertEquals(sMessage,homePage.payment_InfoMsg.getText());
    }

    @Step
    public void ClickOnPaymentInfo() throws InterruptedException {
        homePage.payment_Info_ContinueBtn.click();
        WaitUntilLoadNextStep("payment_infoDetails");
    }

    @Step
    public void clickOnConfirmOrder() throws InterruptedException {
        homePage.confirmOrderBtn.click();
        WaitUntilLoadNextStep("confirm_orderDetails");
    }

    @Step
    public void verifyConfirmOrderMsg(String sConfrimOrderMsg) {
        Assert.assertEquals(sConfrimOrderMsg,homePage.OrderConfirmedMsg.getText());
    }

    @Step
    public void getTheOrderNumber() {
        System.out.println(homePage.OrderNumber.getText());
    }

    @Step
    public void clickOnContinueOrder() {
        homePage.OrderCompleteContinueBtn.click();
    }

    @Step
    public void LogoutOftheApplication() {
        homePage.LogOutLink.click();
    }
}
