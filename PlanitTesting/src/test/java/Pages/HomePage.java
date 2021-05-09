package Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {

    @FindBy(xpath="//div[@class='header-links']//a[@class='account']")
    public WebElementFacade accountId;

    @FindBy(xpath="//span[contains(text(),'Shopping cart')]")
    public WebElementFacade shoppingCart;

    @FindBy(xpath="//div[contains(text(),'Your Shopping Cart is empty!')]")
    public WebElementFacade ShoppingCartEmpty;

    @FindBy(name="updatecart")
    public WebElementFacade updatecart;

    @FindBy(xpath="//ul[@class='top-menu']//a[contains(text(),'Books')]")
    public WebElementFacade BooksMenuItem;

    @FindBy(xpath="//div[@class='product-essential']//input[@class='qty-input']")
    public WebElementFacade Qty;

    @FindBy(xpath="//div[@class='product-essential']//span[@itemprop='price']")
    public WebElementFacade price;

    @FindBy(xpath="//div[@class='product-essential']//input[@value='Add to cart']")
    public WebElementFacade AddToCart;

    @FindBy(xpath="//div[@id='bar-notification']/p")
    public WebElementFacade NotificationMsg;

    @FindBy(xpath="(//div[@class='product-grid']/div[1]//a)[1]/img")
    public WebElementFacade productItem;

    @FindBy(xpath="//span[.='Sub-Total:']/parent::td/following-sibling::td//span[@class='product-price']")
    public WebElementFacade SubTotalPrice;

    @FindBy(id="termsofservice")
    public WebElementFacade TermsOfConditionCheckbox;

    @FindBy(id="checkout")
    public WebElementFacade checkout;

    @FindBy(id="billing-address-select")
    public WebElementFacade BillingAddressCmb;

    @FindBy(id="BillingNewAddress_CountryId")
    public WebElementFacade BillingCountryCmb;

    @FindBy(id="BillingNewAddress_City")
    public WebElementFacade BillingNewAddress_CityTxt;

    @FindBy(id="BillingNewAddress_Address1")
    public WebElementFacade BillingNewAddress_Address1;

    @FindBy(id="BillingNewAddress_ZipPostalCode")
    public WebElementFacade BillingNewAddress_ZipPostalCodeTxt;

    @FindBy(id="BillingNewAddress_PhoneNumber")
    public WebElementFacade BillingNewAddress_PhoneNumberTxt;

    @FindBy(xpath="//div[@id='billing-buttons-container']/input[@title='Continue']")
    public WebElementFacade billing_ContinueBtn;

    @FindBy(id="shipping-address-select")
    public WebElementFacade shippingAddressCmb;

    @FindBy(xpath="//div[@id='shipping-buttons-container']/input[@title='Continue']")
    public WebElementFacade shipping_ContinueBtn;

    @FindBy(xpath="//label[contains(text(),'Next Day Air')]/preceding-sibling::input")
    public WebElementFacade shipping_Method_NextDayAirOpt;

    @FindBy(xpath="//div[@id='shipping-method-buttons-container']/input[@value='Continue']")
    public WebElementFacade shipping_Method_ContinueBtn;

    @FindBy(xpath="//input[@value='Payments.CashOnDelivery']")
    public WebElementFacade paymentCODOpt;

    @FindBy(xpath="//div[@id='payment-method-buttons-container']/input[@value='Continue']")
    public WebElementFacade payment_Method_ContinueBtn;

    @FindBy(xpath="//div[@id='checkout-payment-info-load']//p")
    public WebElementFacade payment_InfoMsg;

    @FindBy(xpath="//div[@id='payment-info-buttons-container']/input[@value='Continue']")
    public WebElementFacade payment_Info_ContinueBtn;

    @FindBy(xpath="//div[@id='confirm-order-buttons-container']/input[@value='Confirm']")
    public WebElementFacade confirmOrderBtn;

    @FindBy(xpath="//strong[.='Your order has been successfully processed!']")
    public WebElementFacade OrderConfirmedMsg;

    @FindBy(xpath="//a[.='Click here for order details.']/../preceding-sibling::li")
    public WebElementFacade OrderNumber;

    @FindBy(xpath="//div[@class='section order-completed']//input[@value='Continue']")
    public WebElementFacade OrderCompleteContinueBtn;

    @FindBy(xpath = "//a[.='Log out']")
    public WebElementFacade LogOutLink;



}
