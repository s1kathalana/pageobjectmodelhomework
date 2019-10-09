package NopcommerceusingPageobjectmodel;

import org.openqa.selenium.By;
import org.testng.Assert;

public class BuyProductSuccessfully extends Utils
{
    LoadProp props = new LoadProp();
    private By _addtocart = By.xpath("//input[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/18/1/1\"),!1']");
    private By _shoppingcart = By.xpath("//span[@class='cart-label']");
    private By _checkbox = By.xpath("//input[@type=\"checkbox\"][@id=\"termsofservice\"]");
    private By _checkout = By.xpath("//button[@class=\"button-1 checkout-button\"]");
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



    public void clickonaddtocart()
    {
        clickOnElement(_addtocart);
        delay();
        clickOnElement(_shoppingcart);
        clickOnElement(_checkbox);
        clickOnElement(_checkout);

    }

    public void paymentmethod()
    {
        delay();
        clickOnElement(_continue);
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
        clickOnElement(_confirmorder);
        delay();
    }
    public void verifyorderplacedsuccessfully()
    {
        Assert.assertEquals(getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']")),"Your order has been successfully processed!");
    }



}
