package NopcommerceusingPageobjectmodel;

import org.openqa.selenium.By;
import org.testng.Assert;

public class GuestBuyProductSuccessfully extends Utils
{
    LoadProp props = new LoadProp();
    private By _checkoutasguest = By.xpath("//input[@class=\"button-1 checkout-as-guest-button\"]");
    private By _firstname = By.xpath("//input[@data-val-required=\"First name is required.\"]");
    private By _lastname = By.xpath("//input[@data-val-required=\"Last name is required.\"]");
    private By _guestemail = By.xpath("//input[@data-val-required=\"Email is required.\"]");
    private By _country = By.xpath("//select[@data-url=\"/country/getstatesbycountryid\"]");
    private By _city = By.xpath("//input[@data-val-required=\"City is required\"]");
    private By _address = By.xpath("//input[@data-val-required=\"Street address is required\"]");
    private By _zipcode = By.xpath("//input[@data-val-required=\"Zip / postal code is required\"]");
    private By _phone = By.xpath("//input[@data-val-required=\"Phone is required\"]");
    private By _continue = By.xpath("//input[@onclick=\"Billing.save()\"]");
    private By _shippingmethodcontinue = By.xpath("//input[@onclick=\"ShippingMethod.save()\"]");
    private By _paymentmethodcontinue = By.xpath("//input[@onclick=\"PaymentMethod.save()\"]");
    private By _selectpaymentmethod = By.xpath("//input[@id=\"paymentmethod_1\"][@type=\"radio\"]");
    private By _cardholdername = By.xpath("//input[@data-val-required='Enter cardholder name']");
    private By _cardnumber = By.xpath("//input[@maxlength='22']");
    private By _cardcode = By.xpath("//input[@maxlength='4']");
    private By _paymentsubmitcontinue = By.xpath("//input[@onclick=\"PaymentInfo.save()\"]");
    private By _month = By.xpath("//select[@data-val-required=\"Expire month is required\"]");
    private By _year = By.xpath("//select[@data-val-required=\"Expire year is required\"]");
    private By _confirmorder = By.xpath("//input[@onclick=\"ConfirmOrder.save()\"]");





    public void clickoncheckoutasguest()
    {
        clickOnElement(_checkoutasguest);
    }

    public void fillingguestdetails()
    {   enterText(_firstname,props.getProperty("firstName"));
        enterText(_lastname,props.getProperty("lastName"));
        enterText(_guestemail,(generateEmail("").replaceAll("[^a-zA-Z0-9]", ""))+"@gmail.com");
        enterText(_country,props.getProperty("country"));
        enterText(_city,props.getProperty("city"));
        enterText(_address,props.getProperty("address"));
        enterText(_zipcode,props.getProperty("zipcode"));
        enterText(_phone,props.getProperty("phone"));
        clickOnElement(_continue);
    }

    public void guestpaymentdetails()
    {
        delay();
        clickOnElement(_shippingmethodcontinue);
        delay();
        clickOnElement(_selectpaymentmethod);
        clickOnElement(_paymentmethodcontinue);
        delay();
        enterText(_cardholdername,props.getProperty("cardholdername"));
        enterText(_cardnumber,props.getProperty("cardnumber"));
        enterText(_month,props.getProperty("month"));
        enterText(_year,props.getProperty("year"));
        enterText(_cardcode,props.getProperty("cardcode"));
        clickOnElement(_paymentsubmitcontinue);
        delay();
        clickOnElement((_confirmorder));
        delay();
    }
    public void verifyorderplacedsuccessfully()
    {
        Assert.assertEquals(getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']")),"Your order has been successfully processed!");
    }
}
